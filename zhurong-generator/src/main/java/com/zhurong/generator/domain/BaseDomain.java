package com.zhurong.generator.domain;

/**
 * 实体基属
 * 2019/3/27
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