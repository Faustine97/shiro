package com.shiro.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.SecurityUtils;

public class ShiroTest {
    JdbcRealm
    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("root", "123456");
        //System.out.println(subject.isAuthenticated());
       try {
           subject.login(token);
           if(subject.isAuthenticated())
           {
               System.out.println("登陆成功");
               if(subject.hasRole("admin"))
               {
                   System.out.println("有admin角色");
               }else {
                   System.out.println("没有admin角色");
               }

               if(subject.isPermitted("search"))
               {
                   System.out.println("有search权限");
               }
               else
               {
                   System.out.println("有search权限");
               }
               if(subject.isPermitted("delete"))
               {
                   System.out.println("有delete权限");
               }
               else {
                   System.out.println("没有delete权限");
               }
           }

       }catch (AuthenticationException e){
           e.printStackTrace();
       }
       // System.out.println(subject.isAuthenticated());
    }
}
