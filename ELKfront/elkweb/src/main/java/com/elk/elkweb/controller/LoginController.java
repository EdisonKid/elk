package com.elk.elkweb.controller;

import com.elk.elkweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Edison
 * @create 2022-04-30 20:04
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", produces = "application/json;charset=utf-8")
    public List login(HttpServletRequest request, @RequestParam("usernam") String username, @RequestParam("password") String password) {
        int code = 404;
        boolean res = loginService.login(username, password);
        if (res) {
            code = 200;
            System.out.println("登录成功");
//            定义session对象并把数据存入session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        } else
            System.out.println("登陆失败，用户名或密码错误");
//        返回状态码和登录名
        ArrayList<Object> result = new ArrayList<>();
        result.add(0, code);
        result.add(1, username);
        return result;
    }
}
