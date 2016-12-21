package com.hxy.lambda;

import javax.swing.*;

public class SwingTest_1
{
    public static void main(String[] args)
    {
        JFrame jframe = new JFrame("hxy");
        JButton jButton = new JButton("button");

        //传统模式
        //        jButton.addActionListener(new ActionListener()
        //        {
        //            @Override
        //            public void actionPerformed(ActionEvent e)
        //            {
        //                System.out.println("Button Pressed!");
        //            }
        //        });

        //使用lambda表达式
        jButton.addActionListener(event -> System.out.println("Button Pressed!"));

        jframe.add(jButton);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
