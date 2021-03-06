package com.hxy.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTest12
{
    public static void main(String[] args) throws Exception
    {
        int[] ports = new int[]{5000, 5001, 5002, 5003, 5004};

        Selector selector = Selector.open();

        for (int i = 0; i < ports.length; i++)
        {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);

            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            serverSocket.bind(address);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("监听端口：" + ports[i]);

        }

        while (true)
        {
            int numbers = selector.select();
            System.out.println("numbers: " + numbers);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectedKeys: " + selectionKeys);

            Iterator<SelectionKey> iter = selectionKeys.iterator();

            while (iter.hasNext())
            {
                SelectionKey selectionKey = iter.next();

                if (selectionKey.isAcceptable())
                {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);

                    socketChannel.register(selector, SelectionKey.OP_READ);

                    iter.remove();

                    System.out.println("获得客户端连接： " + socketChannel);

                }
                else if (selectionKey.isReadable())
                {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    int byteRead = 0;

                    while (true)
                    {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

                        byteBuffer.clear();

                        int read = socketChannel.read(byteBuffer);

                        if (read < 0)
                        {
                            break;
                        }

                        byteBuffer.flip();

                        socketChannel.write(byteBuffer);

                        byteRead += read;

                    }

                    System.out.println("读取： " + byteRead + ",来自于： " + socketChannel);

                    iter.remove();

                }

            }

        }

    }
}
