/**   
 * @Title: BaseDomain.java
 * @Package: com.essence.edop.generator.domain
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.domain;

/**
 * @description: 实体基属
 * @author LZG
 * @date 2019/3/27
 */
public class BaseDomain {

    //类描述
    private String clazzComment;

    //类作者
    private String clazzAuthor;

    //类创建日期
    private String clazzDate;

    public String getClazzComment() {
        return clazzComment;
    }

    public void setClazzComment(String clazzComment) {
        this.clazzComment = clazzComment;
    }

    public String getClazzAuthor() {
        return clazzAuthor;
    }

    public void setClazzAuthor(String clazzAuthor) {
        this.clazzAuthor = clazzAuthor;
    }

    public String getClazzDate() {
        return clazzDate;
    }

    public void setClazzDate(String clazzDate) {
        this.clazzDate = clazzDate;
    }

}