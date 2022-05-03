package com.elk.elkweb.controller;

import com.elk.elkweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Edison
 * @create 2022-04-30 20:04
 */
@Controller
@RequestMapping("/elk")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public List login(HttpServletRequest request, @RequestParam("USER_NAME") String USER_NAME, @RequestParam("USER_PSD") String USER_PSD){
        int code=404;
        boolean res = loginService.login(USER_NAME, USER_PSD);
        if(res) {
            code = 200;
            System.out.println("登录成功");
//            定义session对象并把数据存入session
            HttpSession session = request.getSession();
            session.setAttribute("USER_NAME",USER_NAME);
            session.setAttribute("USER_PSD",USER_PSD);
        }else
            System.out.println("登陆失败，用户名或密码错误");
//        返回状态码和登录名
        ArrayList<Object> result = new ArrayList<>();
        result.add(0,code);
        result.add(1,USER_NAME);
        return result;
    }
}
