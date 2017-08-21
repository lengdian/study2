package com.hxy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//direct buffer
public class NioTest8
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream inputStream = new FileInputStream("input2.txt");
        FileOutputStream outputStream = new FileOutputStream("output2.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        //直接缓冲：堆外内存存放，不需要从jvm内存拷贝一次到系统内存，零拷贝，性能更高
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        while (true)
        {
            byteBuffer.clear();

            int read = inputChannel.read(byteBuffer);
            System.out.println("read1: " + read);
            if (-1 == read)
            {
                break;
            }

            byteBuffer.flip();

            outputChannel.write(byteBuffer);

        }

        inputChannel.close();
        outputChannel.close();
    }
}
