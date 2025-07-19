/**   
 * @Title: Book.java
 * @Package: com.zhurong.utils.xml
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @description: 
 * @author LZG
 * @date 2018/8/27
 */
@XmlRootElement(name="book") //XML根元素  name属性定义了XML根元素的元素名
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "bookName", "price", "bookDesc" }) //propOrder 属性在xml里的出现顺序
public class Book {

    @XmlElement(name = "name") //定义生成后的xml的属性名
    private String bookName;

    @XmlElement(name = "price")
    private String price;

    @XmlElement(name = "desc")
    private String bookDesc;

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return the bookDesc
     */
    public String getBookDesc() {
        return bookDesc;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @param bookDesc the bookDesc to set
     */
    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    /*
     * @see java.lang.Object#toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Book [bookName=" + bookName + ", price=" + price + ", bookDesc=" + bookDesc + "]";
    }

    /**
     * 这个方法省略, 给jaxb使用
     */
    public Book() {
        super();
    }

    /**
     * @param bookName
     * @param price
     * @param bookDesc
     */
    public Book(String bookName, String price, String bookDesc) {
        super();
        this.bookName = bookName;
        this.price = price;
        this.bookDesc = bookDesc;
    }

}