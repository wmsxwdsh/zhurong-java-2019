/**   
 * @Title: CacheVerifyRecordDaoImpl.java
 * @Package: com.zhurong.utils.db.dao
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.db.dao;

import com.zhurong.utils.db.domain.CacheVerifyRecord;
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
public class CacheVerifyRecordDaoImpl implements CacheVerifyRecordDao {

    private QueryRunner runner = null; // 查询运行器

    public CacheVerifyRecordDaoImpl() {
        runner = new QueryRunner();
    }

    // 方法：向数据库中添加一条记录
    @Override
    public void add(CacheVerifyRecord record) throws SQLException {
        String sql = "insert into tb_cache_verify_record(card_name, id_no, card_no, bank_name, phone_num)values(?,?,?,?,?)";
        runner.update(com.zhurong.utils.db.DBUtil.getConnection(), sql, record.getCardName(), record.getIdNo(), record.getCardNo(),
            record.getBankName(), record.getPhoneNum());
    }

    // 方法：根据id向数据库中修改某条记录
    @Override
    public void update(CacheVerifyRecord record) throws SQLException {
        String sql = "update tb_cache_verify_record set card_name=?,id_no=?,card_no=?,bank_name=?,phone_num=? where id=?";
        runner.update(com.zhurong.utils.db.DBUtil.getConnection(), sql, record.getCardName(), record.getIdNo(), record.getCardNo(),
            record.getBankName(), record.getPhoneNum());
    }

    // 方法：根据id删除数据库中的某条记录
    @Override
    public void delete(String id) throws SQLException {
        String sql = "delete from tb_cache_verify_record where id=?";
        runner.update(com.zhurong.utils.db.DBUtil.getConnection(), sql, id);
    }

    // 方法：使用BeanHandler查询一个对象
    @Override
    public CacheVerifyRecord findById(String id) throws SQLException {
        String sql = "select id, card_name, id_no, card_no, bank_name, phone_num from tb_cache_verify_record where id = ?";
        CacheVerifyRecord record = runner.query(com.zhurong.utils.db.DBUtil.getConnection(), sql,
            new BeanHandler<CacheVerifyRecord>(CacheVerifyRecord.class), id);
        return record;
    }

    // 方法：使用BeanListHandler查询所有对象
    @Override
    public List<CacheVerifyRecord> findAll() throws SQLException {
        String sql = "select id, card_name, id_no, card_no, bank_name, phone_num from tb_cache_verify_record";
        List<CacheVerifyRecord> records = runner.query(com.zhurong.utils.db.DBUtil.getConnection(), sql,
            new BeanListHandler<CacheVerifyRecord>(CacheVerifyRecord.class));
        return records;
    }

    // 方法：使用ScalarHandler查询一共有几条记录
    @Override
    public long cacheVerifyRecordCount() throws SQLException {
        String sql = "select count(ORDER_ID) from tb_cache_verify_record";
        return runner.query(com.zhurong.utils.db.DBUtil.getConnection(), sql, new ScalarHandler<Long>());
    }

    @Override
    public List<CacheVerifyRecord> findCacheVerifyRecordByBankName(String bankName) throws SQLException {
        String sql = "select id, merch_id, card_name, id_no, card_no, bank_name, phone_num from tb_cache_verify_record where bank_name=?";
        List<CacheVerifyRecord> records = runner.query(com.zhurong.utils.db.DBUtil.getConnection(), sql,
            new BeanListHandler<CacheVerifyRecord>(CacheVerifyRecord.class), bankName);
        return records;
    }

}