package com.zemoso.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: cms.proto")
public final class CmsBlogGrpc {

  private CmsBlogGrpc() {}

  public static final String SERVICE_NAME = "CmsBlog";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Usercredential,
      com.zemoso.grpc.proto.Grpcsocialuser> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = com.zemoso.grpc.proto.Usercredential.class,
      responseType = com.zemoso.grpc.proto.Grpcsocialuser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Usercredential,
      com.zemoso.grpc.proto.Grpcsocialuser> getLoginMethod() {
    io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Usercredential, com.zemoso.grpc.proto.Grpcsocialuser> getLoginMethod;
    if ((getLoginMethod = CmsBlogGrpc.getLoginMethod) == null) {
      synchronized (CmsBlogGrpc.class) {
        if ((getLoginMethod = CmsBlogGrpc.getLoginMethod) == null) {
          CmsBlogGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.zemoso.grpc.proto.Usercredential, com.zemoso.grpc.proto.Grpcsocialuser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CmsBlog", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Usercredential.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Grpcsocialuser.getDefaultInstance()))
                  .setSchemaDescriptor(new CmsBlogMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Logincms,
      com.zemoso.grpc.proto.Bloglist> getPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "post",
      requestType = com.zemoso.grpc.proto.Logincms.class,
      responseType = com.zemoso.grpc.proto.Bloglist.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Logincms,
      com.zemoso.grpc.proto.Bloglist> getPostMethod() {
    io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Logincms, com.zemoso.grpc.proto.Bloglist> getPostMethod;
    if ((getPostMethod = CmsBlogGrpc.getPostMethod) == null) {
      synchronized (CmsBlogGrpc.class) {
        if ((getPostMethod = CmsBlogGrpc.getPostMethod) == null) {
          CmsBlogGrpc.getPostMethod = getPostMethod = 
              io.grpc.MethodDescriptor.<com.zemoso.grpc.proto.Logincms, com.zemoso.grpc.proto.Bloglist>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CmsBlog", "post"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Logincms.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Bloglist.getDefaultInstance()))
                  .setSchemaDescriptor(new CmsBlogMethodDescriptorSupplier("post"))
                  .build();
          }
        }
     }
     return getPostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Blog,
      com.zemoso.grpc.proto.Blog> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "create",
      requestType = com.zemoso.grpc.proto.Blog.class,
      responseType = com.zemoso.grpc.proto.Blog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Blog,
      com.zemoso.grpc.proto.Blog> getCreateMethod() {
    io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Blog, com.zemoso.grpc.proto.Blog> getCreateMethod;
    if ((getCreateMethod = CmsBlogGrpc.getCreateMethod) == null) {
      synchronized (CmsBlogGrpc.class) {
        if ((getCreateMethod = CmsBlogGrpc.getCreateMethod) == null) {
          CmsBlogGrpc.getCreateMethod = getCreateMethod = 
              io.grpc.MethodDescriptor.<com.zemoso.grpc.proto.Blog, com.zemoso.grpc.proto.Blog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CmsBlog", "create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Blog.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Blog.getDefaultInstance()))
                  .setSchemaDescriptor(new CmsBlogMethodDescriptorSupplier("create"))
                  .build();
          }
        }
     }
     return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zemoso.grpc.proto.DeletePost,
      com.zemoso.grpc.proto.Blog> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete",
      requestType = com.zemoso.grpc.proto.DeletePost.class,
      responseType = com.zemoso.grpc.proto.Blog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zemoso.grpc.proto.DeletePost,
      com.zemoso.grpc.proto.Blog> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.zemoso.grpc.proto.DeletePost, com.zemoso.grpc.proto.Blog> getDeleteMethod;
    if ((getDeleteMethod = CmsBlogGrpc.getDeleteMethod) == null) {
      synchronized (CmsBlogGrpc.class) {
        if ((getDeleteMethod = CmsBlogGrpc.getDeleteMethod) == null) {
          CmsBlogGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.zemoso.grpc.proto.DeletePost, com.zemoso.grpc.proto.Blog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CmsBlog", "delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.DeletePost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Blog.getDefaultInstance()))
                  .setSchemaDescriptor(new CmsBlogMethodDescriptorSupplier("delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Comment,
      com.zemoso.grpc.proto.Blog> getPostcommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "postcomment",
      requestType = com.zemoso.grpc.proto.Comment.class,
      responseType = com.zemoso.grpc.proto.Blog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Comment,
      com.zemoso.grpc.proto.Blog> getPostcommentMethod() {
    io.grpc.MethodDescriptor<com.zemoso.grpc.proto.Comment, com.zemoso.grpc.proto.Blog> getPostcommentMethod;
    if ((getPostcommentMethod = CmsBlogGrpc.getPostcommentMethod) == null) {
      synchronized (CmsBlogGrpc.class) {
        if ((getPostcommentMethod = CmsBlogGrpc.getPostcommentMethod) == null) {
          CmsBlogGrpc.getPostcommentMethod = getPostcommentMethod = 
              io.grpc.MethodDescriptor.<com.zemoso.grpc.proto.Comment, com.zemoso.grpc.proto.Blog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CmsBlog", "postcomment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Comment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.zemoso.grpc.proto.Blog.getDefaultInstance()))
                  .setSchemaDescriptor(new CmsBlogMethodDescriptorSupplier("postcomment"))
                  .build();
          }
        }
     }
     return getPostcommentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CmsBlogStub newStub(io.grpc.Channel channel) {
    return new CmsBlogStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CmsBlogBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CmsBlogBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CmsBlogFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CmsBlogFutureStub(channel);
  }

  /**
   */
  public static abstract class CmsBlogImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(com.zemoso.grpc.proto.Usercredential request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Grpcsocialuser> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void post(com.zemoso.grpc.proto.Logincms request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Bloglist> responseObserver) {
      asyncUnimplementedUnaryCall(getPostMethod(), responseObserver);
    }

    /**
     */
    public void create(com.zemoso.grpc.proto.Blog request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.zemoso.grpc.proto.DeletePost request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    public void postcomment(com.zemoso.grpc.proto.Comment request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog> responseObserver) {
      asyncUnimplementedUnaryCall(getPostcommentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.zemoso.grpc.proto.Usercredential,
                com.zemoso.grpc.proto.Grpcsocialuser>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getPostMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.zemoso.grpc.proto.Logincms,
                com.zemoso.grpc.proto.Bloglist>(
                  this, METHODID_POST)))
          .addMethod(
            getCreateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.zemoso.grpc.proto.Blog,
                com.zemoso.grpc.proto.Blog>(
                  this, METHODID_CREATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.zemoso.grpc.proto.DeletePost,
                com.zemoso.grpc.proto.Blog>(
                  this, METHODID_DELETE)))
          .addMethod(
            getPostcommentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.zemoso.grpc.proto.Comment,
                com.zemoso.grpc.proto.Blog>(
                  this, METHODID_POSTCOMMENT)))
          .build();
    }
  }

  /**
   */
  public static final class CmsBlogStub extends io.grpc.stub.AbstractStub<CmsBlogStub> {
    private CmsBlogStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CmsBlogStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmsBlogStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CmsBlogStub(channel, callOptions);
    }

    /**
     */
    public void login(com.zemoso.grpc.proto.Usercredential request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Grpcsocialuser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void post(com.zemoso.grpc.proto.Logincms request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Bloglist> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void create(com.zemoso.grpc.proto.Blog request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.zemoso.grpc.proto.DeletePost request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void postcomment(com.zemoso.grpc.proto.Comment request,
        io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostcommentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CmsBlogBlockingStub extends io.grpc.stub.AbstractStub<CmsBlogBlockingStub> {
    private CmsBlogBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CmsBlogBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmsBlogBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CmsBlogBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.zemoso.grpc.proto.Grpcsocialuser login(com.zemoso.grpc.proto.Usercredential request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.zemoso.grpc.proto.Bloglist post(com.zemoso.grpc.proto.Logincms request) {
      return blockingUnaryCall(
          getChannel(), getPostMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.zemoso.grpc.proto.Blog create(com.zemoso.grpc.proto.Blog request) {
      return blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.zemoso.grpc.proto.Blog delete(com.zemoso.grpc.proto.DeletePost request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.zemoso.grpc.proto.Blog postcomment(com.zemoso.grpc.proto.Comment request) {
      return blockingUnaryCall(
          getChannel(), getPostcommentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CmsBlogFutureStub extends io.grpc.stub.AbstractStub<CmsBlogFutureStub> {
    private CmsBlogFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CmsBlogFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmsBlogFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CmsBlogFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zemoso.grpc.proto.Grpcsocialuser> login(
        com.zemoso.grpc.proto.Usercredential request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zemoso.grpc.proto.Bloglist> post(
        com.zemoso.grpc.proto.Logincms request) {
      return futureUnaryCall(
          getChannel().newCall(getPostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zemoso.grpc.proto.Blog> create(
        com.zemoso.grpc.proto.Blog request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zemoso.grpc.proto.Blog> delete(
        com.zemoso.grpc.proto.DeletePost request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.zemoso.grpc.proto.Blog> postcomment(
        com.zemoso.grpc.proto.Comment request) {
      return futureUnaryCall(
          getChannel().newCall(getPostcommentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_POST = 1;
  private static final int METHODID_CREATE = 2;
  private static final int METHODID_DELETE = 3;
  private static final int METHODID_POSTCOMMENT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CmsBlogImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CmsBlogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((com.zemoso.grpc.proto.Usercredential) request,
              (io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Grpcsocialuser>) responseObserver);
          break;
        case METHODID_POST:
          serviceImpl.post((com.zemoso.grpc.proto.Logincms) request,
              (io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Bloglist>) responseObserver);
          break;
        case METHODID_CREATE:
          serviceImpl.create((com.zemoso.grpc.proto.Blog) request,
              (io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.zemoso.grpc.proto.DeletePost) request,
              (io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog>) responseObserver);
          break;
        case METHODID_POSTCOMMENT:
          serviceImpl.postcomment((com.zemoso.grpc.proto.Comment) request,
              (io.grpc.stub.StreamObserver<com.zemoso.grpc.proto.Blog>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CmsBlogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CmsBlogBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.zemoso.grpc.proto.Cms.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CmsBlog");
    }
  }

  private static final class CmsBlogFileDescriptorSupplier
      extends CmsBlogBaseDescriptorSupplier {
    CmsBlogFileDescriptorSupplier() {}
  }

  private static final class CmsBlogMethodDescriptorSupplier
      extends CmsBlogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CmsBlogMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CmsBlogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CmsBlogFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getPostMethod())
              .addMethod(getCreateMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getPostcommentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
