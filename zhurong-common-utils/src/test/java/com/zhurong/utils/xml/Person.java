/**   
 * @Title: Person.java
 * @Package: com.zhurong.utils.xml
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @description: 
 * @author LZG
 * @date 2018/8/27
 */
@XmlRootElement(name = "person") //XML根元素  name属性定义了XML根元素的元素名
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "idCard", "name", "book" }) //propOrder 属性在xml里的出现顺序
public class Person {

    @XmlElement(name = "personId") //定义生成后的xml的属性名
    private String idCard;

    @XmlElement(name = "PersonName")
    private String name;

    @XmlElementWrapper(name = "PersonBook")
    @XmlElement(name = "book")
    private List<Book> book;

    /**
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the book
     */
    public List<Book> getBook() {
        return book;
    }

    /**
     * @param idCard the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param book the book to set
     */
    public void setBook(List<Book> book) {
        this.book = book;
    }

    /**
     *
     */
    public Person() {
        super();
    }

    /**
     * @param idCard
     * @param name
     * @param book
     */
    public Person(String idCard, String name, List<Book> book) {
        super();
        this.idCard = idCard;
        this.name = name;
        this.book = book;
    }

    /*
     * @see java.lang.Object#toString()
     * @return
     */
    @Override
    public String toString() {
        return "Person [idCard=" + idCard + ", name=" + name + ", book=" + book + "]";
    }

}
