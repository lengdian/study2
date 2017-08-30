package com.hxy.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient
{
    public static void main(String[] args) throws Exception
    {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress("localhost", 8899));

        while (true)
        {
            selector.select();

            Set<SelectionKey> keySet = selector.selectedKeys();
            for (SelectionKey key : keySet)
            {
                if (key.isConnectable())
                {
                    SocketChannel client = (SocketChannel) key.channel();

                    if (client.isConnectionPending())
                    {
                        client.finishConnect();

                        ByteBuffer writeBuffer = ByteBuffer.allocate(512);
                        writeBuffer.put((LocalDateTime.now() + "连接成功").getBytes());
                        writeBuffer.flip();

                        client.write(writeBuffer);

                        ExecutorService executorService = Executors.newSingleThreadExecutor(Executors
                                .defaultThreadFactory());
                        executorService.submit(() -> {
                            while (true)
                            {
                                try
                                {
                                    writeBuffer.clear();
                                    InputStreamReader reader = new InputStreamReader(System.in);
                                    BufferedReader br = new BufferedReader(reader);

                                    String sendMsg = br.readLine();

                                    writeBuffer.put(sendMsg.getBytes());
                                    writeBuffer.flip();
                                    client.write(writeBuffer);

                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }

                            }
                        });
                    }

                    client.register(selector, SelectionKey.OP_READ);
                }
                else if (key.isReadable())
                {
                    SocketChannel client = (SocketChannel) key.channel();

                    ByteBuffer readBuffer = ByteBuffer.allocate(512);
                    int count = client.read(readBuffer);
                    if (count > 0)
                    {
                        String receiveMsg = new String(readBuffer.array(), 0, count);
                        System.out.println(receiveMsg);
                    }
                }
            }

            keySet.clear();

        }
    }
}
