package com.zhurong.jwt.service;

import com.zhurong.jwt.entity.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author LZG
 * @date 2022.04.06
 */
@Service
public class UserService {

    public User getUser(String userid, String password) {
        if ("admin".equals(userid) && "admin".equals(password)) {
            User user = new User();
            user.setUserID("admin");
            user.setUserName("admin");
            user.setPassWord("admin");
            return user;
        } else {
            return null;
        }
    }

    public User getUser(String userid) {
        if ("admin".equals(userid)) {
            User user = new User();
            user.setUserID("admin");
            user.setUserName("admin");
            user.setPassWord("admin");
            return user;
        } else {
            return null;
        }
    }

}
