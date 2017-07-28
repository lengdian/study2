package com.hxy.sixthExample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage>
{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception
    {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        int randomInt = new Random().nextInt(3);

        MyDataInfo.MyMessage msg;

        if (randomInt == 0)
        {
            msg = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).setPerson
                    (MyDataInfo.Person.newBuilder().setName("hxy").setAge(27).setAddress("guangzhou").build()).build();
        }
        else if (randomInt == 1)
        {
            msg = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).setDog
                    (MyDataInfo.Dog.newBuilder().setName("dog").setAge(2).build()).build();
        }
        else
        {
            msg = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).setCat
                    (MyDataInfo.Cat.newBuilder().setName("cat").setAge(1).build()).build();
        }

        ctx.channel().writeAndFlush(msg);
    }


}
