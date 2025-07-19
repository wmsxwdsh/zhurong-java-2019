/**   
 * @Title: Person.java
 * @Package: com.zhurong.utils.db.domain
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.db.domain;

/**
 * @description: 
 * @author LZG
 * @date 2018/8/27
 */
public class Person {

    private int id;
    private String name;
    private int age;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person(int id, String name, int age, String description) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public Person(String name, int age, String description) {
        super();
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public Person() {
        super();
    }

    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", description=" + description + "]";
    }

}