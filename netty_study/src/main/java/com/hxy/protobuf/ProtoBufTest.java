package com.hxy.protobuf;

public class ProtoBufTest
{
    public static void main(String[] args) throws Exception
    {
        DataInfo.Student student=DataInfo.Student.newBuilder().setName("hxy").setAge(27).setAddress("guangzhou").build();

        byte[] student2ByteArray=student.toByteArray();

        DataInfo.Student student2=DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student2);
    }

}
