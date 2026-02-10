package com.zhurong.springboot.test.cookie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class TestCookieController {

    @GetMapping(value = "/doGet2")
    public void doGet2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("mayun", "马云");
        //获取session的Id
        String sessionId = session.getId();
        //判断session是不是新创建的
        if (session.isNew()) {
            response.getWriter().print("session创建成功，session的id是："+sessionId);
        }else {
            response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
        }
    }

    @GetMapping(value = "/doGet")
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("admin", System.currentTimeMillis() + "");
        // 设置生命周期为MAX_VALUE
        cookie.setMaxAge(Integer.MAX_VALUE);
        resp.addCookie(cookie);
    }

}

