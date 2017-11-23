package com.hxy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static javafx.scene.input.KeyCode.G;

//@Controller
//@ResponseBody
//该注解等同于上面两个注解一起使用
@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class TestController
{
    //属性文件用法
    //    @Value("${hxy.name}")
    //    private String name;
    @Value("${content}")
    private String content;
    @Value("${env}")
    private String env;

    @RequestMapping(value = {"/test", "/test2"}, method = {RequestMethod.GET, RequestMethod.POST})
        //    @GetMapping 组合注解，上面注解简化版本，使用get方式
        //    @PostMapping 组合注解，上面注解简化版本，使用post方式
    String test()
    {
        System.out.println(content);
        System.out.println(env);
        return "hello world";
    }

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(TestController.class, args);
    }
}
