package com.zhurong.designpattern.chuangjianxing5.prototype;


import java.io.Serializable;

/**
 * 邮件
 * 2019/3/19
 */
public class EMail implements Serializable, Cloneable {

    private String id; //唯一标识

    private String title; //标题

    private String addressee; //收件人

    private String content; //内容

    private Attachment attachment; //附件

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    @Override
    protected EMail clone() throws CloneNotSupportedException {
        return (EMail) super.clone();
    }

    public EMail deepClone() throws CloneNotSupportedException {
        EMail cloneEMail = (EMail) super.clone();
        cloneEMail.setAttachment(cloneEMail.attachment.clone());
        return cloneEMail;
    }

}