package com.hxy.nio;

import java.nio.ByteBuffer;

//只读buffer,不能将一个只读buffer转换为读写buffer
public class NioTest7
{
    public static void main(String[] args)
    {
        ByteBuffer buffer=ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for(int i=0;i<buffer.capacity();i++)
        {
            buffer.put((byte)i);
        }

        ByteBuffer readonlyBuffer=buffer.asReadOnlyBuffer();

        System.out.println(readonlyBuffer.getClass());

        buffer.position(0);
        buffer.put((byte)125);

        buffer.flip();
        readonlyBuffer.flip();

        System.out.println(buffer.get());
        System.out.println(readonlyBuffer.get());
    }
}
