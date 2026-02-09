package com.zhurong.utils.security;

import com.zhurong.utils.common.LinkStrUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/**
 * RSA 加签验密工具类
 * 2019/5/17
 */
public class RSAUtil {

    //测试
    public static void main(String[] args) throws Exception {

        //以下的公私钥是用KeyTool生成的
        String publicKey =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPhDuZsuI7vga1HZvC9cn/Pb1s40CT48iqnyhS8UnLb8k6mfpzBidiJMSpGpaYubW0n9FYuoBCnSd2"
                + "+IOxwZ5d1XMMWTJ3ujlxL/CWir+V9ZJX23Xcp+vxQ5KWKXtH1v1Y54xhZddf9SqSD5c/GNQqG0w7DS81N3vGPEGYFSUnTQIDAQAB";
        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAI+EO5my4ju+BrUdm8L1yf89vWzjQJPjyKqfKFLxSctvyTqZ"
            + "+nMGJ2IkxKkalpi5tbSf0Vi6gEKdJ3b4g7HBnl3VcwxZMne6OXEv8JaKv5X1klfbddyn6/FDkpYpe0fW/VjnjGFl11"
            + "/1KpIPlz8Y1CobTDsNLzU3e8Y8QZgVJSdNAgMBAAECgYBLDzmstSYlYMlZSFcCrFItMDk2DdTkhCmbMwp/9rpFr/1qrMWUCw"
            + "/mAJzqZIGG9vnVshBne4NBU7gkPO2DtmQAmAfZkjZWmGXSkiL2tMzq3TUdZtVSVMrWRMft4/VuU1T/GWJsjM/wYwj+x/eWY2AkCs+/vLC2"
            + "+OlOubrAXmtu8QJBAPklSIWYYqn3"
            + "/rKtQMqtBZU5S37rj99bqi5vTRIlImjsNm7uASyzjxtLRRqo4pnD4rAm6JU9X8lymIbSwjcxPrMCQQCTdwKyxREKMBj0LzkDHXiMzVzQyz1hyM71IAn"
            + "+51onYy74l6O3ghAauIn8BhCIGMw4qItoQcCQmWsb+7X7QwH/AkBS2x5SJ4pwYiQXAd0xSfc4WDSOQgK30kE3bhZgeW8HG79Chu5nElP"
            + "+TLrvkcjCQE3MLTReJWoMkYq+E6s5NaxXAkBLQS/SVXlVrqf9bV/19ANCL8dPEnkXvufG9nvDZwN"
            + "+GEKvQIufKbPYPxbD08B6A9WskG7cXLnN0U108Wa0fES3AkBlWj7DCpYyYtAAqvpkM+9PBej5OP0beAmxN9reC5dBpinR+MuDypsdEC+gZ"
            + "/oLcsj2z6mtMlrCt1xVP1I6mIqf";

        System.out.println("publicKey：" + publicKey);
        System.out.println("privateKey：" + privateKey);

        //请求参数封装Map
        Map<String, Object> strMap = new HashMap<String, Object>();
        //strMap.put("merch_id", "99980001");
        //strMap.put("tran_flowid", "1111111111111111");
        //strMap.put("version", "v1.0");

        strMap.put("accountId", "admin");
        strMap.put("name", "刘德华");
        strMap.put("device", "android");
        strMap.put("note", "hello world.");

        //按字母顺序将参数拼接成字符串用于加答
        String jsonStr = LinkStrUtil.createLinkString(strMap, true);
        System.out.println("---------------------------------------------");

        String sign = RSAUtil.signByPrivateKey(jsonStr, privateKey);
        System.out.println("测试加签的报文数据：" + jsonStr);
        System.out.println("sign：" + sign);
        System.out.println("验签：" + RSAUtil.verifySignByPublicKey(jsonStr, publicKey, sign));

        System.out.println("---------------------------------------------");
        String mingWen = "收复一切洪水猛兽，外面的、心里的……";
        System.out.println("测试加密的明文数据：" + mingWen);
        String cipherText = RSAUtil.encryptByPublicKey(mingWen, RSAUtil.readPublicKeyFromString(publicKey));
        System.out.println("加密后：" + cipherText);
        String plainText = RSAUtil.decryptByPrivateKey(cipherText, RSAUtil.readPrivateKeyFromString(privateKey));
        System.out.println("解密后：" + plainText);
    }

    /**
     * 生成公钥私钥
     * @param filePath 生成文件路径
     * @date 2018/10/15
     */
    @SuppressWarnings("static-access")
    public static void getKeyPair(String filePath) {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = keyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGenerator.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        String publicKeyString = Base64.encode(publicKey.getEncoded());
        String privateKeyString = Base64.encode(privateKey.getEncoded());
        try {
            BufferedWriter publicbw = new BufferedWriter(new FileWriter(new File(filePath + "/publicKey.keystore")));
            BufferedWriter privatebw = new BufferedWriter(new FileWriter(new File(filePath + "/privateKey.keystore")));
            publicbw.write(publicKeyString);
            privatebw.write(privateKeyString);
            publicbw.flush();
            publicbw.close();
            privatebw.flush();
            privatebw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从文件中读取公钥或私钥
     * @param filePath filePath 文件路径
     * @return java.lang.String 公钥或私钥
     * @date 2018/10/15
     */
    public static String readKeyFromFile(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                sb.append(readLine);
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 从字符串中加载公钥
     * @return java.security.interfaces.RSAPublicKey
     * @date 2018/10/15
     */
    public static RSAPublicKey readPublicKeyFromString(String publicKeyStr) {
        try {
            byte[] bt = Base64.decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bt);
            return (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从字符串中加载私钥
     * @return java.security.interfaces.RSAPrivateKey
     * @date 2018/10/15
     */
    public static RSAPrivateKey readPrivateKeyFromString(String privateKeyStr) {
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decode(privateKeyStr));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥加签
     * @param content 明文
     * @param privateKey 私钥
     * @return java.lang.String 签名值
     * @date 2018/10/15
     */
    public static String signByPrivateKey(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA256withRSA");// MD5withRSA
            signature.initSign(priKey);
            signature.update(content.getBytes());
            byte[] sign = signature.sign();
            return Base64.encode(sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥验签
     * @param content json串
     * @param publicKey 公钥
     * @param sign 签名值
     * @return boolean 验签是否通过
     * @date 2018/10/15
     */
    public static boolean verifySignByPublicKey(String content, String publicKey, String sign) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(publicKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA256withRSA");// MD5withRSA
            signature.initVerify(pubKey);
            signature.update(content.getBytes());
            return signature.verify(Base64.decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 公钥加密
     * @param plainText 明文
     * @param publicKey 公钥
     * @return java.lang.String
     * @date 2018/10/15
     */
    public static String encryptByPublicKey(String plainText, RSAPublicKey publicKey) throws Exception {
        if (publicKey == null) {
            throw new Exception("公钥为空！");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(plainText.getBytes());
            return Base64.encode(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥解密
     * @param cipherText 密文
     * @param privateKey 私钥
     * @return java.lang.String
     * @date 2018/10/15
     */
    public static String decryptByPrivateKey(String cipherText, RSAPrivateKey privateKey) throws Exception {
        if (privateKey == null) {
            throw new Exception("私钥为空！");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(Base64.decode(cipherText));
            return new String(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}