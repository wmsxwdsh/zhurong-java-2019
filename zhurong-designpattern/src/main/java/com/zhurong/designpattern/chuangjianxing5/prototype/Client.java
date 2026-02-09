/**
 * @Title: Client.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.prototype
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.prototype;


import com.zhurong.utils.idgen.UuidUtil;

public class Client {

    public static void main(String[] args) throws Exception {
        EMail eMail = new EMail();
        eMail.setId(UuidUtil.get32UUIDStr());
        eMail.setTitle("测试111");
        eMail.setContent("内容222");
        eMail.setAddressee("helloworld@qq.com");

        Attachment attachment = new Attachment();
        attachment.setId(UuidUtil.get32UUIDStr());
        attachment.setFileName("淘宝技术这十年.pdf");
        attachment.setFilePah("d://books//淘宝技术这十年.pdf");

        eMail.setAttachment(attachment);

        //浅克隆
        EMail eMailClone = eMail.clone();
        System.out.println("eMail和eMailClone是否为同一个对象: " + (eMail == eMailClone)); //false
        System.out.println("eMail attachment和eMailClone attachment是否为同一个对象："
                        + (eMail.getAttachment() == eMailClone.getAttachment())); //true

        //深克隆
        EMail eMailDeepClone = eMailClone.deepClone();
        System.out.println("eMail和eMailDeepClone是否同一个对象：" + (eMail == eMailDeepClone)); //false
        System.out.println("eMail attachment和eMailDeepClone attachement是否为同一个对象："
                        + (eMail.getAttachment() == eMailDeepClone.getAttachment()));

    }

}