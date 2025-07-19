/**   
 * @Title: PersonDao.java
 * @Package: com.zhurong.utils.db.dao
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.db.dao;

import com.zhurong.utils.db.domain.Person;
import java.sql.SQLException;
import java.util.List;

/**
 * @description: 
 * @author LZG
 * @date 2018/8/27
 */
public interface PersonDao {

    // 添加方法
    public void add(Person p) throws SQLException;

    // 更新方法
    public void update(Person p) throws SQLException;

    // 删除方法
    public void delete(int id) throws SQLException;

    // 查找方法
    public Person findById(int id) throws SQLException;

    // 查找所有
    public List<Person> findAll() throws SQLException;

    // 查询有几条记录
    public long personCount() throws SQLException;
}