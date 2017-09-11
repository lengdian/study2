package com.hxy.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldIOServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(8899);

        while (true)
        {
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try
            {
                byte[] byteBuffer = new byte[4096];

                while (true)
                {
                    int readCount = dataInputStream.read(byteBuffer, 0, byteBuffer.length);
                    if (readCount == -1)
                    {
                        break;
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


        }
    }
}
