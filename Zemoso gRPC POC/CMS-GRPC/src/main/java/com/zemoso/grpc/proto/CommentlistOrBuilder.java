// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cms.proto

package com.zemoso.grpc.proto;

public interface CommentlistOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Commentlist)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 commentlistid = 1;</code>
   */
  long getCommentlistid();

  /**
   * <code>repeated .Comment comments = 2;</code>
   */
  java.util.List<com.zemoso.grpc.proto.Comment> 
      getCommentsList();
  /**
   * <code>repeated .Comment comments = 2;</code>
   */
  com.zemoso.grpc.proto.Comment getComments(int index);
  /**
   * <code>repeated .Comment comments = 2;</code>
   */
  int getCommentsCount();
  /**
   * <code>repeated .Comment comments = 2;</code>
   */
  java.util.List<? extends com.zemoso.grpc.proto.CommentOrBuilder> 
      getCommentsOrBuilderList();
  /**
   * <code>repeated .Comment comments = 2;</code>
   */
  com.zemoso.grpc.proto.CommentOrBuilder getCommentsOrBuilder(
      int index);
}
