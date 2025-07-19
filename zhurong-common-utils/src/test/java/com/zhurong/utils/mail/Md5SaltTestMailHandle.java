/**   
 * @Title: TestMailHandle.java
 * @Package: com.zhurong.utils.mail
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.mail;

import com.zhurong.utils.TheOthers.FreemarkerUtil;
import com.zhurong.utils.properties.PropertiesUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.junit.Test;

/**
 * @description: MailHandle测试类
 * @author LZG
 * @date 2018/8/27
 */
public class Md5SaltTestMailHandle {

    // 异步发送邮件测试
    @Test
    public void test163EmailAsynSend() throws Exception {
        EmailHandle emailHandle = new EmailHandle(MailKit.SMTP_163);
        emailHandle.setNamePass("waitingtoshine@163.com", "haocome2014");
        emailHandle.setFrom("waitingtoshine@163.com");
        emailHandle.setNeedAuth(true);
        emailHandle.setSubject("测试主题");
        emailHandle.setBody("测试内容");
        emailHandle.setTo("635555803@qq.com");
        emailHandle.asynSendEmail();

    }

    // 163邮箱发送HTML邮件
    @Test
    public void test163EmailSendWithHtmlContent() throws Exception {
        EmailHandle emailHandle = new EmailHandle(MailKit.SMTP_163);
        emailHandle.setNamePass("waitingtoshine@163.com", "haocome2014");
        emailHandle.setFrom("waitingtoshine@163.com");
        emailHandle.setNeedAuth(true);

        //邮件主题和邮件模板名称都需要在mail.properties里设置，统一管理。
        Properties properties = PropertiesUtil.read("/config/mail.properties");
        String registerSubject = (String) properties.get("mail.subject.register");
        String registerFtl = (String) properties.get("mail.ftl.register");

        emailHandle.setSubject(registerSubject);

        //第1种:最粗爆简单的
        //emailHandle.setBody(".......");

        //第2种：从freemaker模板获取的
        Map<String, Object> ftlDataMap = new HashMap<String, Object>();
        ftlDataMap.put("link_url", "http://www.中关村e世界.com");
        String htmlContent = FreemarkerUtil.geneFileStr(registerFtl, "src\\main\\resources\\mailTemplate", ftlDataMap);

        emailHandle.setBody(htmlContent);

        emailHandle.setTo("liuzhongguo@zhongshuheyi.com");
        emailHandle.sendEmail();
    }

    // 163邮箱发送邮件并抄送
    @Test
    public void test163EmailWithCC() throws Exception {
        EmailHandle emailHandle = new EmailHandle(MailKit.SMTP_163);
        emailHandle.setNamePass("waitingtoshine@163.com", "haocome2014");
        emailHandle.setFrom("waitingtoshine@163.com");
        emailHandle.setNeedAuth(true);
        emailHandle.setSubject("测试主题");
        emailHandle.setBody("测试内容");
        emailHandle.setTo("liuzhongguo@zhongshuheyi.com");

        //抄送设置
        emailHandle.setCopyTo("635555803@qq.com");
        //emailHandle.setCopyToList("635555803@qq.com, services@zhongshuheyi.com");

        emailHandle.sendEmail();
    }

    // 163邮箱带附件发送邮件
    @Test
    public void test163EmailWithFileAffix() throws Exception {
        EmailHandle emailHandle = new EmailHandle(MailKit.SMTP_163);
        emailHandle.setNamePass("waitingtoshine@163.com", "haocome2014");
        emailHandle.setFrom("waitingtoshine@163.com");
        emailHandle.setNeedAuth(true);
        emailHandle.setSubject("测试主题");
        emailHandle.setBody("测试内容");
        emailHandle.setTo("liuzhongguo@zhongshuheyi.com");

        //支持中文 1、E:\\林志玲.jpg 2、E:\\linzhiling.jpg
        emailHandle.addFileAffix("E:\\林志玲.jpg");
        emailHandle.addFileAffix("E:\\林志玲职业装照.jpg");

        emailHandle.sendEmail();
    }

    // 163邮箱发送邮件
    public static void test163EmailSend() throws Exception {

        EmailHandle emailHandle = new EmailHandle(MailKit.SMTP_163);
        emailHandle.setNamePass("waitingtoshine@163.com", "haocome2014");
        emailHandle.setFrom("waitingtoshine@163.com");
        emailHandle.setNeedAuth(true);
        emailHandle.setSubject("测试主题");
        emailHandle.setBody("测试内容");
        emailHandle.setTo("635555803@qq.com");
        emailHandle.sendEmail();
    }

    // QQ邮箱发送邮件
    public static void testQQEmailSend() throws Exception {

        // qq邮箱做为服务器邮箱,需要开始SSL(true),密码用授权码
        EmailHandle emailHandle = new EmailHandle(MailKit.SMTP_QQ, true);
        emailHandle.setNamePass("635555803@qq.com", "jsntxgeaplznbfig");
        emailHandle.setFrom("635555803@qq.com");
        emailHandle.setNeedAuth(true);
        emailHandle.setSubject("测试主题");
        emailHandle.setBody("测试内容");
        emailHandle.setTo("635555803@qq.com");
        emailHandle.sendEmail();
    }

    // 腾讯企业邮箱发送邮件 https://exmail.qq.com
    public static void testExmailQQEmailSend() throws Exception {
        EmailHandle emailHandle = new EmailHandle(MailKit.SMTP_EXMAIL_QQ);
        emailHandle.setNamePass("services@zhongshuheyi.com", "Zshy@1qaz");
        emailHandle.setFrom("services@zhongshuheyi.com");
        emailHandle.setNeedAuth(true);
        emailHandle.setSubject("测试主题");
        emailHandle.setBody("测试内容");
        emailHandle.setTo("635555803@qq.com");
        emailHandle.sendEmail();
    }

    /**
     * @Description: Gmail邮箱发送邮件
     *      目前发送不成功！
     *      发送不成功因为：https://blog.csdn.net/zhouzhimin/article/details/52807512
     * @return void
     * @author LZG
     * @date 2018/8/27
     */
    public static void testGmailSend() throws Exception {
        EmailHandle emailHandle = new EmailHandle(MailKit.SMTP_GMAIL);
        emailHandle.setNamePass("liuzhongguochn@gmail.com", "Lhaocome2014");
        emailHandle.setFrom("liuzhongguochn@gmail.com");
        emailHandle.setNeedAuth(true);
        emailHandle.setSubject("测试主题");
        emailHandle.setBody("测试内容");
        emailHandle.setTo("635555803@qq.com");
        emailHandle.sendEmail();
    }

}