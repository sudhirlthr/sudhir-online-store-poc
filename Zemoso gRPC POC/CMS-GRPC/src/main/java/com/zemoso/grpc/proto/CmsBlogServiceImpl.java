
package com.zemoso.grpc.proto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.zemoso.grpc.model.Comments;
import com.zemoso.grpc.model.Post;
import com.zemoso.grpc.model.Socialuser;
import com.zemoso.grpc.proto.CmsBlogGrpc.CmsBlogImplBase;
import com.zemoso.grpc.service.BlogService;
import com.zemoso.grpc.service.CommentService;
import com.zemoso.grpc.service.SocialusersService;
import com.zemoso.grpc.service.UsersService;
import com.zemoso.grpc.util.BeanUtil;
import com.zemoso.grpc.util.Constant;

import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class CmsBlogServiceImpl extends CmsBlogImplBase {


	@Override
	public void login(Usercredential request, StreamObserver<Grpcsocialuser> responseObserver) {
		SocialusersService usersService = BeanUtil.getBean(SocialusersService.class);
		Socialuser socialuser = usersService.getUserByEmail(request.getUsername());
		Grpcsocialuser.Builder grpcsocialuser = Grpcsocialuser.newBuilder();
		if (socialuser != null && socialuser.getPassword().equals(request.getPassword())) {
			grpcsocialuser.setEmail(socialuser.getEmail());
			grpcsocialuser.setFirstName(socialuser.getFirstName());
			grpcsocialuser.setLastName(socialuser.getLastName());
			grpcsocialuser.setUserid(socialuser.getUserid());
			Map<String, Object> claims = new HashMap<>();
			claims.put("email", socialuser.getEmail());
			claims.put("firstName", socialuser.getFirstName());
			claims.put("lastName_", socialuser.getLastName());
			claims.put("userid", socialuser.getUserid().toString());
			final String jwt_token = Jwts.builder().setSubject("token").addClaims(claims)
					.signWith(SignatureAlgorithm.HS256, Constant.JWT_SIGNING_KEY).compact();
			grpcsocialuser.setToken(jwt_token);
		}
		responseObserver.onNext(grpcsocialuser.build());
		responseObserver.onCompleted();
	}

	@Override
	public void post(Logincms request, StreamObserver<Bloglist> responseObserver) {
		BlogService blogService = BeanUtil.getBean(BlogService.class);
		CommentService commentService = BeanUtil.getBean(CommentService.class);
		List<Post> blogs = blogService.getAllBlogs();

		Bloglist.Builder bloglist = Bloglist.newBuilder();
		Blog.Builder protobufBlog = Blog.newBuilder();
		for (int i = 0; i < blogs.size(); i++) {
			protobufBlog = Blog.newBuilder();
			protobufBlog.setBlogid(blogs.get(i).getBlogid());
			protobufBlog.setTitle(blogs.get(i).getTitle());
			protobufBlog.setContent(blogs.get(i).getContent());
			protobufBlog.setRefuser(blogs.get(i).getRefuser().getEmail());
			protobufBlog.setCreationdate(blogs.get(i).getCreationdate().toString());

			List<Comments> allCommentsByPost = commentService.getAllCommentsByPost(blogs.get(i));
			Commentlist.Builder commentList = Commentlist.newBuilder();
			if (allCommentsByPost.size() > 0
					&& (allCommentsByPost.get(0) != null || allCommentsByPost.get(0).getContent() != null)) {
				int j = 0;
				for (Comments comment : allCommentsByPost) {
					Comment.Builder grpcComment = Comment.newBuilder();
					grpcComment.setCommentsid(comment.getCommentsid());
					grpcComment.setBlogid(blogs.get(i).getBlogid());
					grpcComment.setCommentsdate(comment.getCommentsdate());
					grpcComment.setContent(comment.getContent());
					grpcComment.setRefuser(comment.getRefuser().getEmail());

					commentList.addComments(grpcComment);
				}
			}
			protobufBlog.setComments(commentList);

			bloglist.addBlogs(protobufBlog.build());
		}
		responseObserver.onNext(bloglist.build());
		responseObserver.onCompleted();
	}

	@Override
	public void create(Blog request, StreamObserver<Blog> responseObserver) {
		BlogService blogService = BeanUtil.getBean(BlogService.class);
		SocialusersService userService = BeanUtil.getBean(SocialusersService.class);
		Post post = new Post();

		post.setContent(request.getContent());
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

		Socialuser user = userService.getUserByEmail(request.getRefuser());
		if(user == null) {
			Socialuser newSocialuser = new Socialuser();
			newSocialuser.setComments(new ArrayList<Comments>());
			newSocialuser.setConfirmationToken(UUID.randomUUID().toString());
			newSocialuser.setEmail(request.getRefuser());
			newSocialuser.setFirstName(request.getRefuser());
			newSocialuser.setPassword(request.getRefuser());
			newSocialuser.setLastName(request.getRefuser());
			newSocialuser.setRefblog(new ArrayList<Post>());
			user = userService.saveUsers(newSocialuser);
		}
		post.setRefuser(user);
		post.setTitle(request.getTitle());
		ArrayList<Comments> commentList = new ArrayList<>();

		List<Comment> grpcCommentsList = request.getComments().getCommentsList();
		if (grpcCommentsList != null && grpcCommentsList.size() > 0) {
			for (Comment comment : grpcCommentsList) {
				Comments commentModel = new Comments();
				commentModel
						.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
				commentModel.setContent(comment.getContent());
				commentModel.setRefblog(post);
				commentModel.setRefuser(post.getRefuser());
				commentList.add(commentModel);
			}
		}

		post.setComments(commentList);

		Post createdBlog = blogService.createBlog(post);

		Blog.Builder userBlog = Blog.newBuilder();
		userBlog.setBlogid(createdBlog.getBlogid());
		Commentlist.Builder commentListBuilder = Commentlist.newBuilder();
		userBlog.setComments(commentListBuilder);
		userBlog.setContent(createdBlog.getContent());
		userBlog.setCreationdate(createdBlog.getCreationdate().toString());
		userBlog.setRefuser(createdBlog.getRefuser().getEmail());
		userBlog.setTitle(createdBlog.getTitle());

		responseObserver.onNext(userBlog.build());
		responseObserver.onCompleted();
	}

	@Override
	public void delete(DeletePost request, StreamObserver<Blog> responseObserver) {
		BlogService blogService = BeanUtil.getBean(BlogService.class);

		Post usersBlog = blogService.getPostByid(request.getBlogid());

		Blog.Builder userBlog = Blog.newBuilder();
		userBlog.setBlogid(usersBlog.getBlogid());
		Commentlist.Builder commentListBuilder = Commentlist.newBuilder();
		userBlog.setComments(commentListBuilder);
		userBlog.setContent(usersBlog.getContent());
		userBlog.setCreationdate(usersBlog.getCreationdate().toString());
		userBlog.setRefuser(usersBlog.getRefuser().getEmail());
		userBlog.setTitle(usersBlog.getTitle());

		// delete Blog blogService.deteteBlog(request.getBlogid());

		responseObserver.onNext(userBlog.build());
		responseObserver.onCompleted();
	}

	@Override
	public void postcomment(Comment request, StreamObserver<Blog> responseObserver) {

		BlogService blogService = BeanUtil.getBean(BlogService.class);
		CommentService commentService = BeanUtil.getBean(CommentService.class);
		SocialusersService socialusersService = BeanUtil.getBean(SocialusersService.class);

		Post postByid = blogService.getPostByid(request.getBlogid());

		Socialuser socialuser = socialusersService.getUserByEmail(request.getRefuser());
		if(socialuser == null) {
			Socialuser newSocialuser = new Socialuser();
			newSocialuser.setComments(new ArrayList<Comments>());
			newSocialuser.setConfirmationToken(UUID.randomUUID().toString());
			newSocialuser.setEmail(request.getRefuser());
			newSocialuser.setFirstName(request.getRefuser());
			newSocialuser.setPassword(request.getRefuser());
			newSocialuser.setLastName(request.getRefuser());
			newSocialuser.setRefblog(new ArrayList<Post>());
			socialuser = socialusersService.saveUsers(newSocialuser);
		}
		
		Comments userComments = new Comments();
		userComments.setRefblog(postByid);
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setRefuser(socialuser);
		userComments.setContent(request.getContent());

		Comments savedComments = commentService.addComments(userComments);

		if (savedComments != null) {
			Post savedCommnetsPost = blogService.getPostByid(savedComments.getRefblog().getBlogid());
			Blog.Builder commentedBlog = Blog.newBuilder();
			commentedBlog.setBlogid(savedCommnetsPost.getBlogid());
			commentedBlog.setTitle(savedCommnetsPost.getTitle());
			commentedBlog.setContent(savedCommnetsPost.getContent());

			commentedBlog.setCreationdate(savedCommnetsPost.getCreationdate());
			commentedBlog.setRefuser(savedCommnetsPost.getRefuser().getEmail());

			List<Comments> allCommentsByPost = commentService.getAllCommentsByPost(savedCommnetsPost);
			Commentlist.Builder commentListBuilder = Commentlist.newBuilder();
			if (allCommentsByPost != null
					&& (allCommentsByPost.get(0) != null || allCommentsByPost.get(0).getContent() != null)) {
				int j = 0;
				for (Comments comment : allCommentsByPost) {
					Comment.Builder grpcComment = Comment.newBuilder();
					grpcComment.setCommentsid(comment.getCommentsid());
					grpcComment.setBlogid(comment.getRefblog().getBlogid());
					grpcComment.setCommentsdate(comment.getCommentsdate());
					grpcComment.setContent(comment.getContent());
					grpcComment.setRefuser(comment.getRefuser().getEmail());

					commentListBuilder.addComments(grpcComment);
				}
			}
			commentedBlog.setComments(commentListBuilder);

			responseObserver.onNext(commentedBlog.build());
		}
		responseObserver.onCompleted();
	}


}
