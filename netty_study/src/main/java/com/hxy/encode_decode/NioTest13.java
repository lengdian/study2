package com.hxy.encode_decode;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NioTest13
{
    public static void main(String[] args) throws Exception
    {
        String inputFile = "NioTest13.txt";
        String ouputFile = "NioTest13_Out.txt";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(ouputFile, "rw");

        long inputLength = new File(inputFile).length();

        FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
        FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLength);

        System.out.println("====================================================");
        Charset.availableCharsets().forEach((k, v) -> System.out.println(k + "," + v));
        System.out.println("====================================================");

        Charset charset = Charset.forName("iso-8859-1");
        //decoder是把字节数组转换成字符串
        CharsetDecoder decoder = charset.newDecoder();
        //encoder是把字符串转换成字节数组
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(inputData);
        System.out.println(new String(charBuffer.array()));

        ByteBuffer outputData = encoder.encode(charBuffer);

        outputFileChannel.write(outputData);

        inputRandomAccessFile.close();
        outputRandomAccessFile.close();


    }
}
