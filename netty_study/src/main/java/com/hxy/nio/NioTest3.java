package com.hxy.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3
{
    public static void main(String[] args) throws Exception
    {
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte[] bytes = "hhxxyy".getBytes();

        for (int i = 0; i < bytes.length; i++)
        {
            byteBuffer.put(bytes[i]);
        }

        byteBuffer.flip();

        fileChannel.write(byteBuffer);
        fileOutputStream.close();


    }
}
