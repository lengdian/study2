// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.hxy.proto;

public final class StudentProto {
  private StudentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hxy_proto_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hxy_proto_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hxy_proto_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hxy_proto_MyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hxy_proto_StudentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hxy_proto_StudentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hxy_proto_StudentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hxy_proto_StudentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hxy_proto_StudentResponseList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hxy_proto_StudentResponseList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hxy_proto_StreamRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hxy_proto_StreamRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hxy_proto_StreamResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hxy_proto_StreamResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rStudent.proto\022\rcom.hxy.proto\"\035\n\tMyRequ" +
      "est\022\020\n\010username\030\001 \001(\t\"\036\n\nMyResponse\022\020\n\010r" +
      "ealname\030\001 \001(\t\"\035\n\016StudentRequest\022\013\n\003age\030\001" +
      " \001(\005\":\n\017StudentResponse\022\014\n\004name\030\001 \001(\t\022\013\n" +
      "\003age\030\002 \001(\005\022\014\n\004city\030\003 \001(\t\"N\n\023StudentRespo" +
      "nseList\0227\n\017studentResponse\030\001 \003(\0132\036.com.h" +
      "xy.proto.StudentResponse\"%\n\rStreamReques" +
      "t\022\024\n\014request_info\030\001 \001(\t\"\'\n\016StreamRespons" +
      "e\022\025\n\rresponse_info\030\001 \001(\t2\334\002\n\016StudentServ" +
      "ice\022L\n\025getRealnameByUsername\022\030.com.hxy.p",
      "roto.MyRequest\032\031.com.hxy.proto.MyRespons" +
      "e\022S\n\020getStudentsByAge\022\035.com.hxy.proto.St" +
      "udentRequest\032\036.com.hxy.proto.StudentResp" +
      "onse0\001\022^\n\027getStudentsWrapperByAge\022\035.com." +
      "hxy.proto.StudentRequest\032\".com.hxy.proto" +
      ".StudentResponseList(\001\022G\n\006biTalk\022\034.com.h" +
      "xy.proto.StreamRequest\032\035.com.hxy.proto.S" +
      "treamResponse(\001B\037\n\rcom.hxy.protoB\014Studen" +
      "tProtoP\001b\006proto3"
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
    internal_static_com_hxy_proto_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_hxy_proto_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hxy_proto_MyRequest_descriptor,
        new String[] { "Username", });
    internal_static_com_hxy_proto_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_hxy_proto_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hxy_proto_MyResponse_descriptor,
        new String[] { "Realname", });
    internal_static_com_hxy_proto_StudentRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_hxy_proto_StudentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hxy_proto_StudentRequest_descriptor,
        new String[] { "Age", });
    internal_static_com_hxy_proto_StudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_hxy_proto_StudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hxy_proto_StudentResponse_descriptor,
        new String[] { "Name", "Age", "City", });
    internal_static_com_hxy_proto_StudentResponseList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_hxy_proto_StudentResponseList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hxy_proto_StudentResponseList_descriptor,
        new String[] { "StudentResponse", });
    internal_static_com_hxy_proto_StreamRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_hxy_proto_StreamRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hxy_proto_StreamRequest_descriptor,
        new String[] { "RequestInfo", });
    internal_static_com_hxy_proto_StreamResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_hxy_proto_StreamResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hxy_proto_StreamResponse_descriptor,
        new String[] { "ResponseInfo", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
