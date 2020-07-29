package com.zemoso.grpc.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zemoso.grpc.CmsGrpcApplicationTests;
import com.zemoso.grpc.proto.Blog;
import com.zemoso.grpc.proto.Bloglist;
import com.zemoso.grpc.proto.CmsBlogGrpc;
import com.zemoso.grpc.proto.CmsBlogServiceImpl;
import com.zemoso.grpc.proto.Comment;
import com.zemoso.grpc.proto.DeletePost;
import com.zemoso.grpc.proto.Grpcsocialuser;
import com.zemoso.grpc.proto.Logincms;
import com.zemoso.grpc.proto.Usercredential;

import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GrpcServiceTest extends CmsGrpcApplicationTests{
	
	private final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();
	private CmsBlogGrpc.CmsBlogBlockingStub blockingStub;

	@BeforeEach
	public void setup() {
		String serverName = InProcessServerBuilder.generateName();
		try {
			grpcCleanup.register(InProcessServerBuilder.forName(serverName).directExecutor().addService(new CmsBlogServiceImpl()).build().start());
			blockingStub = CmsBlogGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// test login
	/*
	 * @Test public void userCredentialTest() { String username =
	 * "sudhirlthr@gmail.com"; String password = "123"; Grpcsocialuser
	 * grpcsocialuser =
	 * blockingStub.login(Usercredential.newBuilder().setUsername(username).
	 * setPassword(password).build()); assertEquals(username,
	 * grpcsocialuser.getEmail()); }
	 */
	
	// get Posts
	@Test
	@Order(1)
	public void getBlogTest() {
		Bloglist bloglist =	blockingStub.post(Logincms.newBuilder().setResponsecode(102).setResponsemessage("Welcome").build());
		assertNotEquals(null, bloglist);
	}
	
	@Test
	@Order(2)
	public void createBlog() {
		Blog blog = blockingStub.create(Blog.newBuilder()
				.setBlogid(101)
				.setTitle("Junit Test")
				.setContent("Junit for Creating blogs")
				.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))
				.setRefuser("sergio@zemosolabs.com")
				.build());
		
		assertNotEquals(null, blog);
	}
	
	@Test
	@Order(4)
	public void deleteBlogTest() {
		Blog blog = blockingStub.create(Blog.newBuilder()
				.setBlogid(101)
				.setTitle("Junit Test")
				.setContent("Junit for Creating blogs")
				.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))
				.setRefuser("sudhirlthr@gmail.com")
				.build());
		
		Blog deletedBlog = blockingStub.delete(DeletePost.newBuilder().setBlogid(blog.getBlogid()).build());
		assertEquals(blog.getBlogid(), deletedBlog.getBlogid());
	}
	
	@Test
	@Order(3)
	public void CommentOnBlogTest() {
		
		Blog blog = blockingStub.create(Blog.newBuilder()
				.setBlogid(101)
				.setTitle("Junit Test for comment on blog")
				.setContent("Junit for giving comments on blog")
				.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))
				.setRefuser("sudhirlthr@gmail.com")
				.build());
		
		String commentContent = "Adding new comments on blog id:"+blog.getBlogid();
		
		Comment.Builder blogComment = Comment.newBuilder()
												.setBlogid(blog.getBlogid())
												.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))
												.setContent("Adding new comments on blog id:"+blog.getBlogid())
												.setRefuser("sergio@zemosolabs.com");
		
		Blog commentedBlog =  blockingStub.postcomment(blogComment.build());
		assertEquals(blog.getBlogid(), commentedBlog.getBlogid());
		assertEquals(commentContent, commentedBlog.getComments().getComments(0).getContent());
	}
}
