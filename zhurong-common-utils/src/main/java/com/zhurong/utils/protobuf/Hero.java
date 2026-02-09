package com.zhurong.utils.protobuf;

import io.protostuff.Tag;

public class Hero {

    // 关于@Tag,要么所有属性都有 @Tag 注解,要么都没有,不能一个类中只有部分属性有@Tag注解

    @Tag(1)
    private String id;

    @Tag(2)
    private String name;

    @Tag(3)
    private String age;

    @Tag(4)
    private String weapon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Hero{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", age='" + age + '\'' +
            ", weapon='" + weapon + '\'' +
            '}';
    }

}