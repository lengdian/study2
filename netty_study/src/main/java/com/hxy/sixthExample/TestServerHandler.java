package com.hxy.sixthExample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static com.hxy.sixthExample.MyDataInfo.MyMessage.DataType.DogType;
import static com.hxy.sixthExample.MyDataInfo.MyMessage.DataType.PersonType;

public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception
    {
        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();

        if (dataType == PersonType)
        {
            System.out.println(msg.getPerson().getName());
        }
        else if (dataType == DogType)
        {
            System.out.println(msg.getDog().getName());
        }
        else
        {
            System.out.println(msg.getCat().getName());
        }
    }
}
