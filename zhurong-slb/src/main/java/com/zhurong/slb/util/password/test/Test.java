package com.zhurong.slb.util.password.test;

import com.zhurong.slb.util.password.BossDigestUtils;

public class Test {

    public static void main(String[] args) {
        encryPassword();
    }

    private static void encryPassword() {
        String password = "123456";
        String md5DigestAsHex = BossDigestUtils.md5DigestAsHex(password.getBytes());
        // 密码 = MD5加盐加密(MD5普通加密的密文+salt)
        String salt = BossDigestUtils.getSalt();
        String md5Password = BossDigestUtils.md5DigestAsHexSalt(md5DigestAsHex, salt);
        System.out.println("salt:" + salt);
        System.out.println("md5password:" + md5Password);
//        autUserEntity.setPassword(md5Password);
//        autUserEntity.setPasswordSalt(salt);

    }

}