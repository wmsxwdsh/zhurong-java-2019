/**
 * @Title: KeyTool.java
 * @Package: com.essence.euauth.web.security
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/**
 * @description: 部分摘自阿里巴巴KeyUtilApp.jar（已开源）
 *         --等同于用 蚂蚁金服RSA生成工具生成
 * @author LZG
 * @date 2019/5/17
 */
public class KeyTool {

    //0公钥，1私钥
    public static String[] generateKey(KeyType keytype) {
        KeyPairGenerator keyPairGenerator;

        try {
            keyPairGenerator = KeyPairGenerator.getInstance(keytype.getName());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("不支持的算法名称：" + keytype.getName());
        }

        SecureRandom secureRandom = new SecureRandom();
        keyPairGenerator.initialize(keytype.getLength(), secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String[] result = new String[2];
        result[0] = Base64.encode(publicKey.getEncoded());
        result[1] = Base64.encode(privateKey.getEncoded());

        return result;
    }


    //test
    public static void main(String[] args) {
        String[] keyArr = generateKey(KeyType.RSA1024);
        System.out.println("公钥的长度：" + keyArr[0].length()); //216
        System.out.println("私钥的长度：" + keyArr[1].length()); //844
    }

}