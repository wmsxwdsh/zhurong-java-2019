/**
 * @Title: Attachment.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.prototype
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.prototype;

import java.io.Serializable;

/**
 * @description:
 * @author LZG
 * @date 2019/3/19
 */
public class Attachment implements Serializable, Cloneable {

    private String id;

    private String fileName; //附件文件名

    private String filePah; //附件路径


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePah() {
        return filePah;
    }

    public void setFilePah(String filePah) {
        this.filePah = filePah;
    }

    @Override
    public Attachment clone() throws CloneNotSupportedException {
        return (Attachment) super.clone();
    }
}