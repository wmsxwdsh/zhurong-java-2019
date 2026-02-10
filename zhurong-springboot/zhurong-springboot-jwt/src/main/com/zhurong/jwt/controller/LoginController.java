package com.zhurong.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhurong.jwt.config.LoginToken;
import com.zhurong.jwt.entity.User;
import com.zhurong.jwt.service.TokenService;
import com.zhurong.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2022.04.06
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("login")
    public Object login(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        User user = userService.getUser(username, password);
        if (user == null) {
            jsonObject.put("message", "登录失败！");
            return jsonObject;
        } else {
            String token = tokenService.getToken(user);
            jsonObject.put("token", token);
            jsonObject.put("user", user);
            return jsonObject;
        }
    }

    @LoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

}
