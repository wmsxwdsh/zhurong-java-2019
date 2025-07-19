/**
 * @Title: PersonService.java
 * @Package: com.zhurong.utils.db.service
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.db.service;


import com.zhurong.utils.db.dao.PersonDao;
import com.zhurong.utils.db.dao.PersonDaoImpl;
import com.zhurong.utils.db.domain.Person;
import java.sql.SQLException;
import java.util.List;

/**
 * @description: DBUtil的使用
 * @author LZG
 * @date 2018/8/27
 */
public class PersonService {

    private static PersonDao dao = new PersonDaoImpl();

    public static void main(String[] args) throws SQLException {

//		addPerson();
//		updatePerson();
//		deletePerson();
//		findPersonById();
//		findAllPerson();
        peronCount();
    }

    // 统计
    public static void peronCount() throws SQLException {
        long count = dao.personCount();
        System.out.println(count);
    }

    // 查询所有
    public static void findAllPerson() throws SQLException {
        List<Person> persons = dao.findAll();
        System.out.println(persons);
    }

    // 查询单个
    public static void findPersonById() throws SQLException {
        Person p = dao.findById(2);
        System.out.println(p);
    }

    // 删除
    public static void deletePerson() throws SQLException {
        dao.delete(4);
    }

    // 修改
    public static void updatePerson() throws SQLException {
        dao.update(new Person(4, "叶孤城", 26, "我是通过Java命令而修改的记录"));
    }

    // 新增
    public static void addPerson() throws SQLException {
        dao.add(new Person("西门吹雪", 22, "我是通过Java命令而增加的记录"));
    }

}