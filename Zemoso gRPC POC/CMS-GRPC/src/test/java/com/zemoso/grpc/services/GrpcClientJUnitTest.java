package com.zemoso.grpc.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.AdditionalAnswers.delegatesTo;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
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

import io.grpc.CallCredentials;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;

@Disabled
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GrpcClientJUnitTest extends CmsGrpcApplicationTests{
	
	  public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

	  private final CmsBlogGrpc.CmsBlogImplBase serviceImpl =
	      mock(CmsBlogGrpc.CmsBlogImplBase.class, delegatesTo(
	          new CmsBlogGrpc.CmsBlogImplBase() {	          
	          }));

	  private AuthClient client;

	  @BeforeEach
	  public void setUp() throws Exception {
	    String serverName = InProcessServerBuilder.generateName();
	    grpcCleanup.register(InProcessServerBuilder
	        .forName(serverName).directExecutor().addService(serviceImpl).build().start());
	    
	    ManagedChannel channel = grpcCleanup.register(
	        InProcessChannelBuilder.forName(serverName).directExecutor().build());
	    
	    CallCredentials credential = new JwtCredential("default-client");
	    client = new AuthClient(credential, "localhost", 53003);
	  }

	  @Test
	  public void getBlogJunitTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotEquals(null, bloglist);
	  }
	  
	  @Test
	  public void blogListJunitTestCount() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertTrue(bloglist.getBlogsCount() > 0);
	  }
	  
	  @Test
	  public void getSingleBlogJunittest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotEquals(null, bloglist.getBlogs(0));
	  }
	  
	  @Test
	  public void getBlogsOrBuilderList() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotEquals(null, bloglist.getBlogsOrBuilderList());
	  }
	  @Test
	  public void getBlogsOrBuilderTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotEquals(null, bloglist.getBlogsOrBuilder(0));
	  }
	  
	  @Test
	  public void getBlogshashCodeTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertFalse(bloglist.hashCode() == Bloglist.newBuilder().hashCode());
	  }
	  
	  @Test
	  public void getUnknownFieldsTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotNull(bloglist.getUnknownFields());
	  }
	  
	  @Test
	  public void getDefaultInstanceTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotNull(bloglist.getDefaultInstance());
	  }
	  
	  @Test
	  public void getSerializedSizeTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotNull(bloglist.getSerializedSize());
	  }
	  
	  @Test
	  public void testTwoBlogWithEqual() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertFalse(bloglist.equals(Bloglist.newBuilder()));
	  }
	  
	  @Test
	  public void AddBlogTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotNull(bloglist.newBuilder().addBlogs(Blog.newBuilder()));
	  }
	  @Test
	  public void clearBlogsTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotNull(bloglist.newBuilder().clearBlogs());
	  }
	  @Test
	  public void clearBloglistidTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotNull(bloglist.newBuilder().clearBloglistid());
	  }
	  @Test
	  public void clearBlogTest() {
	    Bloglist bloglist = client.getBlogs("test name");
	    assertNotNull(bloglist.newBuilder().clear());
	  }
	  
}
