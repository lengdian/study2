package com.hxy.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/*
nio网络编程流程（所有连接操作都在一个线程上完成）：
获得ServerSocketChannel对象，配置成非阻塞的通道
绑定端口号到ServerSocket上
获得Selector对象，将ServerSocketChannel（多个）注册到selector上
 */
public class NioServer
{
    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws Exception
    {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true)
        {
            try
            {
                selector.select();
//                System.out.println("触发");

                //这里获取到的是触发了操作的channel的selectorKey的！！！拷贝！！！
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
//                System.out.println(selectionKeys.size());
                selectionKeys.forEach(selectionKey -> {
                    final SocketChannel client;
//                    System.out.println(selectionKey);

                    try
                    {
                        if (selectionKey.isAcceptable())
                        {
                            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                            System.out.println("accept");
                            client = server.accept();
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);

                            String key = "【" + UUID.randomUUID() + "】";

                            clientMap.put(key, client);
                        }
                        else if (selectionKey.isReadable())
                        {
                            client = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(512);

                            int count = client.read(byteBuffer);
                            if (count > 0)
                            {
                                byteBuffer.flip();

                                Charset charset = Charset.forName("utf-8");
                                String receiveMsg = String.valueOf(charset.decode(byteBuffer).array());
                                System.out.println(client + ": " + receiveMsg);

                                clientMap.values().forEach(channel -> {
                                    try
                                    {
//                                        System.out.println("进入");
                                        ByteBuffer writeBuffer=ByteBuffer.allocate(512);
                                        writeBuffer.put(receiveMsg.getBytes());
                                        writeBuffer.flip();
                                        channel.write(writeBuffer);
                                    }
                                    catch (Exception e)
                                    {
                                        e.printStackTrace();
                                    }

                                });
                            }

                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                });

                //清除的并不是原有的selectorKey,而是触发操作的channel的selectorKey的拷贝
                selectionKeys.clear();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


        }


    }

}
