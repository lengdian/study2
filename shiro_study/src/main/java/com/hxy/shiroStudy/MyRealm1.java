package com.hxy.shiroStudy;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

//自定义realm
public class MyRealm1 implements Realm
{
    //返回一个唯一的Realm名字
    @Override
    public String getName()
    {
        return "myRealm1";
    }

    //判断此Realm是否支持此Token
    @Override
    public boolean supports(AuthenticationToken token)
    {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    //根据Token获取认证信息,自定义认证策略
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        String username = (String) token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        if (!"hxy".equals(username))
        {
            throw new UnknownAccountException("账号不存在");
        }
        if (!"61208".equals(password))
        {
            throw new IncorrectCredentialsException("密码错误");
        }

        return new SimpleAuthenticationInfo(username, password, getName());

    }
}
