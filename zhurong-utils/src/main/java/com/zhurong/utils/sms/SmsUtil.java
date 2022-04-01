/**
 * @Title: SmsUtil.java
 * @Package: com.zhurong.utils.sms
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @description: 短信工具类
 * @author LZG
 * @date 2018/9/21
 */
public class SmsUtil {

    // ==========短信商 1（短信通）  http://www.dxton.com/ ======================

    /**
     * @Description: 给一个人发送单条短信
     *      --没有帐号的去官网注册个
     *      --只能使用部分短信模板，自定义短信模板需要公司备案（一般短信平台商都这么搞）
     * @param mobile 手机号
     * @param code 短信内容
     * @return void
     * @author LZG
     * @date 2018/9/21
     */
    public static void sendSms(String mobile, String code) {
        String account = "liuzhongguo123x";
        String password = "123654ax";

        String PostData = "";

        try {
            PostData = "account=" + account + "&password=" + password
                     + "&mobile=" + mobile + "&content=" + URLEncoder.encode(code, "utf-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("短信提交失败");
        }

        String ret = SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
        System.out.println(ret);
    }

    /*
       100			发送成功
 	   101			验证失败
 	   102			手机号码格式不正确
 	   103			会员级别不够
 	   104			内容未审核
 	   105			内容过多
 	   106			账户余额不足
 	   107			Ip受限
 	   108			手机号码发送太频繁，请换号或隔天再发
 	   109			帐号被锁定
 	   110			发送通道不正确
 	   111			当前时间段禁止短信发送
 	   120			系统升级
	*/
    public static String SMS(String postData, String postUrl) {

        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Length", "" + postData.length());

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }

            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
    //======================================================================


    // 测试
    public static void main(String[] args) {
        sendSms("189xxxx7596", "您的验证码是：8080。如需帮助请联系客服。");
    }

}