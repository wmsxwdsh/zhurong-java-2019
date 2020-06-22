/**
 * @Title: Dict.java
 * @Package: com.zhurong.slb.util.fathertoson.entity
 * @author LZG, liuzg@12366.com
 * Copyright (c) 2020 http://www.12366.com
 */
package com.zhurong.slb.util.fathertoson.entity;

import java.io.Serializable;

/**
 * @description:
 * @author LZG
 * @date 2020年06月22日
 */
public class Dict implements Serializable {

    private static final long serialVersionUID = -1336649311025709923L;

    private String id;
    private String parentCodeId;
    private String categoryId;
    private String code;
    private String name;
    private String description;
    private Integer sequence;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentCodeId() {
        return parentCodeId;
    }

    public void setParentCodeId(String parentCodeId) {
        this.parentCodeId = parentCodeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "id='" + id + '\'' +
                ", parentCodeId='" + parentCodeId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}