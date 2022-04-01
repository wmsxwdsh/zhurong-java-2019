package com.zhurong.springboot.test.cookie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author LZG
 * @date 2022年04月01日
 */
@RestController
public class TestCookieController {
    @GetMapping(value = "/doGet")
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("admin", System.currentTimeMillis() + "");
        // 设置生命周期为MAX_VALUE
        cookie.setMaxAge(Integer.MAX_VALUE);
        resp.addCookie(cookie);
    }

}

