package com.zemoso.grpc.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zemoso.grpc.CmsGrpcApplicationTests;
import com.zemoso.grpc.util.Constant;
import com.zemoso.grpc.util.JwtServerInterceptor;
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JwtServerInterceptorTest extends CmsGrpcApplicationTests {

  JwtTokenParser<String> jwtTokenParser =
      jwtToken -> {
        if (jwtToken.equals("Invalid Token")) {
          CompletableFuture<String> res = new CompletableFuture<>();
          res.completeExceptionally(new RuntimeException("invalid token"));
          return res;
        }
        return CompletableFuture.completedFuture(jwtToken);
      };
  JwtServerInterceptor target = new JwtServerInterceptor();
  ServerCall<Object, Object> serverCall = (ServerCall<Object, Object>) mock(ServerCall.class);
  ServerCallHandler<Object, Object> next =
      (ServerCallHandler<Object, Object>) mock(ServerCallHandler.class);

  @Test
  public void closesCallOnMisingHeader() {
    target.interceptCall(serverCall, new Metadata(), next);
    verify(serverCall).close(any(), any());
    verify(next, never()).startCall(any(), any());
  }

  @Test
  public void closesCallOnInvalidHeader() {
    Metadata metadata = new Metadata();
    metadata.put(Constant.AUTHORIZATION_METADATA_KEY, "Bbb");
    target.interceptCall(serverCall, metadata, next);
    verify(serverCall).close(any(), any());
    verify(next, never()).startCall(any(), any());
  }

  @Test
  public void closesCallOnInvalidToken() {
    Metadata metadata = new Metadata();
    metadata.put(Constant.AUTHORIZATION_METADATA_KEY, "Bearer Invalid Token");
    target.interceptCall(serverCall, metadata, next);
    verify(serverCall).close(any(), any());
    verify(next, never()).startCall(any(), any());
  }

  @Test
  public void callNextStageWithContextKeyOnValidHeader() {
    Metadata metadata = new Metadata();
    metadata.put(Constant.AUTHORIZATION_METADATA_KEY, "Bearer test token");
    final AtomicReference<String> actualToken = new AtomicReference<>("");
    when(next.startCall(any(), any()))
        .thenAnswer(
            i -> {
              actualToken.set("AccessToken");
              return null;
            });
    target.interceptCall(serverCall, metadata, next);
    verify(serverCall, never()).close(any(), any());
    verify(next).startCall(any(), any());
    assertEquals("test token", actualToken.get());
  }
}
