package com.hxy.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

//nio零拷贝的gather（聚合）操作：从socket buffer中读取相关文件描述符信息，然后从kernel buffer中读取实际数据，将两个buffer的内容聚合到protocol engine中
//图：nio零拷贝-时序图.png
public class NewIOClient
{
    public static void main(String[] args)  throws Exception
    {
        SocketChannel socketChannel=SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));
        socketChannel.configureBlocking(true);

        String fileName = "F:/共享内容/浏览器/KSbrowser_5.3.108.10728.exe";

        FileChannel fileChannel=new FileInputStream(fileName).getChannel();

        long startTime=System.currentTimeMillis();

        //使用零拷贝方式完成
        long transferCount=fileChannel.transferTo(0,fileChannel.size(),socketChannel);

        System.out.println("发送总字节数; "+transferCount+"，耗时： "+(System.currentTimeMillis()-startTime));

        fileChannel.close();
    }
}
