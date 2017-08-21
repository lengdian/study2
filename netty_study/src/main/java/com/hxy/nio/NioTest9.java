package com.hxy.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//MappedByteBuffer
public class NioTest9
{
    public static void main(String[] args) throws Exception
    {
        RandomAccessFile randomAccessFile=new RandomAccessFile("NioTest9.txt","rw");
        FileChannel fileChannel=randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer=fileChannel.map(FileChannel.MapMode.READ_WRITE,0,5);

        //直接在内存操作文件，剩下的由操作系统帮忙完成（该文件位于堆外内存）
        mappedByteBuffer.put(0,(byte)'a');
        mappedByteBuffer.put(3,(byte)'b');

        randomAccessFile.close();

    }
}
