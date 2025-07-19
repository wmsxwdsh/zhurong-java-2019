/**   
 * @Title: TestXmlUtil.java
 * @Package: com.zhurong.utils.xml
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.xml;

import java.util.ArrayList;
import java.util.List;

import com.zhurong.utils.common.XmlUtil;
import org.junit.Test;

/**
 * @description: XmlUtil测试类
 * @author LZG
 * @date 2018/8/27
 */
public class Md5SaltTestXmlUtil {

    // bean、xmlStr相互转换
    @Test
    public void singleBeanToXmlStr() {
        // Object -> Str
        Book book1 = new Book("深入理解Java虚拟机", "70", "Java好书籍");
        String resultStr = XmlUtil.convertObjToXmlStr(book1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
        System.out.println(resultStr);

        //xml -> Object
        Book book2 = XmlUtil.convertXmlToEntity(resultStr, Book.class);
        System.out.println(book2);

    }

    //复杂的bean(一对多)和xml相互转换
    @Test
    public void complexBeanToXmlStr() {
        Person person = new Person();
        person.setIdCard("370124198710295023");
        person.setName("周红");

        Book book1 = new Book("Java并发", "80", "Java工薪族必备技能");
        Book book2 = new Book("从Paxos到Zookeeper", "100", "Zookeeper选举算法");
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);

        person.setBook(bookList);

        //object -> xml
        String resultStr = XmlUtil.convertObjToXmlStr(person, "", "");
        System.out.println(resultStr);

        //xml -> Object
        Person resultPerson = XmlUtil.convertXmlToEntity(resultStr, Person.class);
        System.out.println(resultPerson);
    }

}