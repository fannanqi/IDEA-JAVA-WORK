package com.example.work8.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.work8.domain.LoginLog;
import com.example.work8.domain.User;
import com.example.work8.service.LoginLogService;
import com.example.work8.service.UserService;
import com.example.work8.utils.MD5Util;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contrller {
    @Autowired
    UserService service;
    @Autowired
    LoginLogService service2;
    @Autowired
    private HttpServlet httpServlet;
    @Autowired
    private HttpServletRequest request;

    public Contrller() {
    }

    @PostMapping({"/login"})
    public String login(@RequestBody User loginUser) {
        String username = loginUser.getUsername();
        String s = MD5Util.string2MD5(loginUser.getPassword());
        loginUser.setPassword(s);
        User result = this.service.loginUser(loginUser);
        System.out.println(result);
        if (result != null) {
            ServletContext servletContext = this.httpServlet.getServletContext();
            servletContext.setAttribute("username", username);
            String o = (String)servletContext.getAttribute("username");
            System.out.println(o);
            return "ok";
        } else {
            return "err";
        }
    }

    @GetMapping({"/getLog"})
    @ResponseBody
    public LoginLog Return() {
        ServletContext servletContext = this.httpServlet.getServletContext();
        String username = (String)servletContext.getAttribute("username");
        System.out.println(username);
        LoginLog log = this.service2.getLog(username);
        System.out.println("log:" + log);
        String ip = this.request.getRemoteAddr();
        System.out.println("ip:" + ip);
        LocalDateTime now = LocalDateTime.now();
        String time = now.toString();
        System.out.println("time:" + time);
        if (log == null) {
            boolean b = this.service2.insertLog(username, time, ip);
            if (b) {
                return this.service2.getLog(username);
            }

            System.out.println("add log error");
        }

        boolean b = this.service2.updataLog(username, time, ip);
        if (!b) {
            System.out.println("updata error");
        }
        return log;
    }

    @PostMapping({"/regist"})
    public String regist(@RequestBody User registUser) {
        String s = MD5Util.string2MD5(registUser.getPassword());
        registUser.setPassword(s);
        boolean b = this.service.registUser(registUser);
        return !b ? "err" : "ok";
    }

    @PostMapping({"/update"})
    public String uodateUser(@RequestBody Map cur) {
        String username = (String)cur.get("username");
        String password =  MD5Util.string2MD5((String)cur.get("password"));
        System.out.println(username + "   " + password);
        Boolean aBoolean = this.service.updateUser(username, password);
        System.out.println(aBoolean);
        return !aBoolean ? "err" : "ok";

    }
}
