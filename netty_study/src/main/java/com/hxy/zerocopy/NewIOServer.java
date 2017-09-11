package com.hxy.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer
{
    public static void main(String[] args) throws Exception
    {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        //当端口号处于TIME_WAIT状态下可以重用
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true)
        {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);

            int readCount = 0;

            while (-1 != readCount)
            {
                try
                {
                    readCount=socketChannel.read(byteBuffer);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                byteBuffer.rewind();
            }


        }


    }
}
