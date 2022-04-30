package com.elk.elkweb.test;

import com.elk.elkweb.service.LoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Edison
 * @create 2022-04-30 20:08
 */
@SpringBootTest
public class LoginTest {

    @Autowired
    LoginService loginService;

    @Test
    public void test1(){
        boolean login = loginService.login("zzp", "123456");
        if(login){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }
}
