package com.zhurong.generator.domain;

/**
 * 字段类
 * 2019/3/27
 */
public class Column {

    /**是否是主键*/
    private Boolean primaryKey;

    /** 数据库字段对应的JAVA文件里的名称（驼峰标识） **/
    private String name; //categoryCode

    /** 数据库字段类型对应的JAVA文件里的类型（String、Integer等） **/
    private String type; //String

    /** 数据库字段首字母大写且去掉下划线字符串 **/
    private String nameUp; //CategoryCode

    /** 数据库字段注释 **/
    private String comment;

    /**原始字段名*/
    private String originalName; //category_code

    /**原始字段类型*/
    private String originalType; //varchar

    public Boolean getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameUp() {
        return nameUp;
    }

    public void setNameUp(String nameUp) {
        this.nameUp = nameUp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
    }

}