/**   
 * @Title: EmailHandle.java
 * @Package: com.zhurong.utils.mail
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.mail;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * @description: 邮件发送处理工具类
 * @author LZG
 * @date 2018/8/27
 */
public class EmailHandle {

    // private static final Logger LOGGER = Logger.getLogger(EmailHandle.class);

    /* 邮件对象 */
    private MimeMessage mimeMsg;

    /* 发送邮件的Session会话 */
    private Session session;

    /* 邮件发送时的一些配置信息的一个属性对象 */
    private Properties props;

    /* 发件人的用户名 */
    private String sendUserName;

    /* 发件人密码 */
    private String sendUserPass;

    /* 附件添加的组件 */
    private Multipart mp;

    /* 存放附件文件 */
    private List<FileDataSource> files = new LinkedList<FileDataSource>();

    /* 是否抄送 */
    private boolean isCC;

    public EmailHandle(String smtp) {
        sendUserName = "";
        sendUserPass = "";
        setSmtpHost(smtp, false);
        createMimeMessage();
    }

    public EmailHandle(String smtp, boolean isSSL) {
        sendUserName = "";
        sendUserPass = "";
        setSmtpHost(smtp, isSSL);
        createMimeMessage();
    }

    private void setSmtpHost(String hostName, boolean isSSL) {
        if (props == null) {
            props = System.getProperties();
        }
        if (isSSL) {
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.socketFactory.port", "465");
        }

        props.put("mail.smtp.host", hostName);
    }

    public boolean createMimeMessage() {
        try {
            // 用props对象来创建并初始化session对象
            session = Session.getDefaultInstance(props, null);
            // 用session对象来创建并初始化邮件对象
            mimeMsg = new MimeMessage(session);
            // 生成附件组件的实例
            mp = new MimeMultipart();
            return true;
        } catch (Exception e) {
            System.err.println("获取邮件会话对象时发生错误！" + e);
            return false;
        }

    }

    // 设置SMTP的身份认证
    public void setNeedAuth(boolean need) {
        if (props == null)
            props = System.getProperties();

        if (need) {
            props.put("mail.smtp.auth", "true");
        } else {
            props.put("mail.smtp.auth", "false");
        }

    }

    // 进行用户身份验证时，设置用户名和密码
    public void setNamePass(String name, String pass) {
        sendUserName = name;
        sendUserPass = pass;
    }

    // 设置邮件主题
    public boolean setSubject(String mailSubject) {
        try {
            mimeMsg.setSubject(mailSubject);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * @Description: 设置邮件内容,并设置其为文本格式或HTML文件格式，编码方式为UTF-8
     * @param mailBody
     * @return boolean
     * @author LZG
     * @date 2018/8/27
     */
    public boolean setBody(String mailBody) {
        try {
            BodyPart bp = new MimeBodyPart();
            bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + mailBody, "text/html;charset=UTF-8");
            // 在组件上添加邮件文本
            mp.addBodyPart(bp);
        } catch (Exception e) {
            System.err.println("设置邮件正文时发生错误！" + e);
            return false;
        }
        return true;
    }

    /**
     * @Description: 增加发送附件
     * @param filename 邮件附件的地址，只能是本机地址而不能是网络地址，否则抛出异常
     * @return boolean
     * @author LZG
     * @date 2018/8/27
     */
    public boolean addFileAffix(String filename) {
        try {
            BodyPart bp = new MimeBodyPart();
            FileDataSource fileds = new FileDataSource(filename);
            bp.setDataHandler(new DataHandler(fileds));
            // 解决附件名称乱码
            bp.setFileName(MimeUtility.encodeText(fileds.getName(), "UTF-8", null));
            // 添加附件
            mp.addBodyPart(bp);
            files.add(fileds);
            return true;
        } catch (Exception e) {
            System.err.println("增加邮件附件<" + filename + ">时发生错误：" + e);
            return false;
        }

    }

    // 删除添加的组件
    public boolean delFileAffix() {
        try {
            FileDataSource fileds = null;
            for (Iterator<FileDataSource> it = files.iterator(); it.hasNext();) {
                fileds = it.next();
                if (null != fileds && null != fileds.getFile())
                    fileds.getFile().delete();
            }
            return true;
        } catch (Exception e) {
            System.err.println("删除邮件附件发生错误：" + e);
            return false;
        }

    }

    // 设置发件人地址
    public boolean setFrom(String from) {
        try {
            mimeMsg.setFrom(new InternetAddress(from));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 设置收件人地址
    public boolean setTo(String to) {
        try {
            if (null == to)
                return false;

            mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 设置收件人地址
    public boolean setToList(String toList) {
        try {
            if (null == toList)
                return false;
            InternetAddress[] iaToList = InternetAddress.parse(toList);
            mimeMsg.setRecipients(Message.RecipientType.TO, iaToList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 发送抄送
    public boolean setCopyTo(String copyTo) {
        try {
            if (null == copyTo)
                return false;
            mimeMsg.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(copyTo));

            isCC = true;

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 发送抄送
    public boolean setCopyToList(String copyToList) {
        try {
            if (null == copyToList)
                return false;
            InternetAddress[] iaCopyToList = InternetAddress.parse(copyToList);
            mimeMsg.setRecipients(javax.mail.Message.RecipientType.CC, iaCopyToList);

            isCC = true;

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description: 同步发送邮件
     * @return boolean
     * @author LZG
     * @date 2018/8/27
     */
    public boolean sendEmail() throws Exception {
        // LOGGER.debug("正在发送邮件....");

        mimeMsg.setContent(mp);
        mimeMsg.saveChanges();
        Session mailSession = Session.getInstance(props, null);
        Transport transport = mailSession.getTransport("smtp");

        // 连接邮件服务器并进行身份验证
        transport.connect((String) props.get("mail.smtp.host"), sendUserName, sendUserPass);

        // 发送邮件
        transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
        // 抄送设置
        if (isCC)
            transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.CC));

        transport.close();

        // LOGGER.debug("发送邮件成功！");
        return true;
    }

    /**
     * @Description: 异步发送邮件
     * @return boolean
     * @author LZG
     * @date 2018/8/27
     */
    public boolean asynSendEmail() throws Exception {
        // LOGGER.debug("正在发送邮件....");

        Boolean flag = Boolean.FALSE;
        FutureTask<Boolean> futureTask = null;
        ExecutorService excutorService = Executors.newCachedThreadPool();
        // 执行任务
        futureTask = new FutureTask<Boolean>(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return sendEmail();
            }
        });

        excutorService.submit(futureTask);

        try {
            // 任务没超时说明发送成功
            flag = futureTask.get(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            futureTask.cancel(true);
            e.printStackTrace();
        } catch (ExecutionException e) {
            futureTask.cancel(true);
            e.printStackTrace();
        } catch (TimeoutException e) {
            futureTask.cancel(true);
            e.printStackTrace();
        } finally {
            excutorService.shutdown();
        }
        return flag;

    }

}