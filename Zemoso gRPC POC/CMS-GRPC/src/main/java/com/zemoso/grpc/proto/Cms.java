// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cms.proto

package com.zemoso.grpc.proto;

public final class Cms {
  private Cms() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Usercredential_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Usercredential_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Logincms_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Logincms_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Blog_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Blog_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Bloglist_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Bloglist_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Comment_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Comment_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Commentlist_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Commentlist_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DeletePost_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DeletePost_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Grpcsocialuser_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Grpcsocialuser_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tcms.proto\"4\n\016Usercredential\022\020\n\010usernam" +
      "e\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"9\n\010Logincms\022\024\n" +
      "\014responsecode\030\001 \001(\005\022\027\n\017responsemessage\030\002" +
      " \001(\t\"}\n\004Blog\022\016\n\006blogid\030\001 \001(\003\022\017\n\007content\030" +
      "\002 \001(\t\022\017\n\007refuser\030\003 \001(\t\022\036\n\010comments\030\004 \001(\013" +
      "2\014.Commentlist\022\r\n\005title\030\005 \001(\t\022\024\n\014creatio" +
      "ndate\030\006 \001(\t\"4\n\010Bloglist\022\022\n\nbloglistid\030\001 " +
      "\001(\003\022\024\n\005blogs\030\002 \003(\0132\005.Blog\"e\n\007Comment\022\022\n\n" +
      "commentsid\030\001 \001(\003\022\017\n\007content\030\002 \001(\t\022\024\n\014com" +
      "mentsdate\030\003 \001(\t\022\016\n\006blogid\030\004 \001(\003\022\017\n\007refus" +
      "er\030\005 \001(\t\"@\n\013Commentlist\022\025\n\rcommentlistid" +
      "\030\001 \001(\003\022\032\n\010comments\030\002 \003(\0132\010.Comment\"\034\n\nDe" +
      "letePost\022\016\n\006blogid\030\001 \001(\003\"c\n\016Grpcsocialus" +
      "er\022\016\n\006userid\030\001 \001(\003\022\r\n\005email\030\002 \001(\t\022\021\n\tfir" +
      "stName\030\003 \001(\t\022\020\n\010lastName\030\004 \001(\t\022\r\n\005token\030" +
      "\005 \001(\t2\250\001\n\007CmsBlog\022)\n\005login\022\017.Usercredent" +
      "ial\032\017.Grpcsocialuser\022\034\n\004post\022\t.Logincms\032" +
      "\t.Bloglist\022\026\n\006create\022\005.Blog\032\005.Blog\022\034\n\006de" +
      "lete\022\013.DeletePost\032\005.Blog\022\036\n\013postcomment\022" +
      "\010.Comment\032\005.BlogB\031\n\025com.zemoso.grpc.prot" +
      "oP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Usercredential_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Usercredential_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Usercredential_descriptor,
        new java.lang.String[] { "Username", "Password", });
    internal_static_Logincms_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Logincms_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Logincms_descriptor,
        new java.lang.String[] { "Responsecode", "Responsemessage", });
    internal_static_Blog_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Blog_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Blog_descriptor,
        new java.lang.String[] { "Blogid", "Content", "Refuser", "Comments", "Title", "Creationdate", });
    internal_static_Bloglist_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Bloglist_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Bloglist_descriptor,
        new java.lang.String[] { "Bloglistid", "Blogs", });
    internal_static_Comment_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Comment_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Comment_descriptor,
        new java.lang.String[] { "Commentsid", "Content", "Commentsdate", "Blogid", "Refuser", });
    internal_static_Commentlist_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Commentlist_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Commentlist_descriptor,
        new java.lang.String[] { "Commentlistid", "Comments", });
    internal_static_DeletePost_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_DeletePost_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DeletePost_descriptor,
        new java.lang.String[] { "Blogid", });
    internal_static_Grpcsocialuser_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Grpcsocialuser_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Grpcsocialuser_descriptor,
        new java.lang.String[] { "Userid", "Email", "FirstName", "LastName", "Token", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
