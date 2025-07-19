/**   
 * @Title: CacheVerifyRecordDao.java
 * @Package: com.zhurong.utils.db.dao
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.db.dao;

import com.zhurong.utils.db.domain.CacheVerifyRecord;
import java.sql.SQLException;
import java.util.List;

/**
 * @description: 
 * @author LZG
 * @date 2018/8/27
 */
public interface CacheVerifyRecordDao {

    // 添加方法
    public void add(CacheVerifyRecord record) throws SQLException;

    // 更新方法
    public void update(CacheVerifyRecord record) throws SQLException;

    // 删除方法
    public void delete(String id) throws SQLException;

    // 查找方法
    public CacheVerifyRecord findById(String id) throws SQLException;

    // 查找所有
    public List<CacheVerifyRecord> findAll() throws SQLException;

    // 查询有几条记录
    public long cacheVerifyRecordCount() throws SQLException;

    // 根据商户号查询
    public List<CacheVerifyRecord> findCacheVerifyRecordByBankName(String bankName) throws SQLException;

}
