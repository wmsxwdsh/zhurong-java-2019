package com.zhurong.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zhurong.jwt.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @date 2022.04.06
 */
@Service
public class TokenService {

    /**
     * 过期时间10分钟
     */
    private static final long EXPIRE_TIME = 10 * 60 * 1000;

    public String getToken(User user) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token="";
        token= JWT.create().withAudience(user.getUserID()) // 将 user id 保存到 token 里面
                .withExpiresAt(date) //十分钟后token过期
                .sign(Algorithm.HMAC256(user.getPassWord())); // 以 password 作为 token 的密钥
        return token;
    }

}
