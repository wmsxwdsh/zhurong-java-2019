/**   
 * @Title: PersonDaoImpl.java
 * @Package: com.zhurong.utils.db.dao
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.db.dao;

import com.zhurong.utils.db.domain.Person;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * @description:
 * @author LZG
 * @date 2018/8/27
 */
public class PersonDaoImpl implements PersonDao {

    private QueryRunner runner = null;//查询运行器
    public PersonDaoImpl(){
        runner = new QueryRunner();
    }

    //方法：向数据库中添加一条记录
    @Override
    public void add(Person p) throws SQLException {
        String sql = "insert into person(name,age,description)values(?,?,?)";
        runner.update(com.zhurong.utils.db.DBUtil.getConnection(), sql, p.getName(), p.getAge(),p.getDescription());
    }

    //方法：根据id向数据库中修改某条记录
    @Override
    public void update(Person p) throws SQLException {
        String sql = "update person set name=?,age=?,description=? where id=?";
        runner.update(com.zhurong.utils.db.DBUtil.getConnection(), sql, p.getName(),p.getAge(),p.getDescription(),p.getId());
    }

    //方法：根据id删除数据库中的某条记录
    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from person where id=?";
        runner.update(com.zhurong.utils.db.DBUtil.getConnection(), sql, id);
    }


    //方法：使用BeanHandler查询一个对象
    @Override
    public Person findById(int id) throws SQLException {
        String sql = "select id, name,age,description from person where id=?";
        Person p = runner.query(com.zhurong.utils.db.DBUtil.getConnection(), sql, new BeanHandler<Person>(Person.class), id);
        return p;
    }

    //方法：使用BeanListHandler查询所有对象
    @Override
    public List<Person> findAll() throws SQLException {
        String sql = "select name,age,description from person";
        List<Person> persons = runner.query(com.zhurong.utils.db.DBUtil.getConnection(), sql, new BeanListHandler<Person>(Person.class));
        return persons;
    }

    //方法：使用ScalarHandler查询一共有几条记录
    @Override
    public long personCount()throws SQLException{
        String sql = "select count(id) from person";
        return runner.query(com.zhurong.utils.db.DBUtil.getConnection(),sql, new ScalarHandler<Long>());
    }

}