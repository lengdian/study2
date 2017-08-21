package com.hxy.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//nio读写文件
public class NioTest4
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true)
        {
            byteBuffer.clear();

            int read = inputChannel.read(byteBuffer);
            System.out.println("read: " + read);
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
