package com.zhurong.utils.db.service;

import com.zhurong.utils.db.dao.CacheVerifyRecordDao;
import com.zhurong.utils.db.dao.CacheVerifyRecordDaoImpl;
import com.zhurong.utils.db.domain.CacheVerifyRecord;
import java.sql.SQLException;
import java.util.List;

public class CacheVerifyRecordService {

    private static CacheVerifyRecordDao dao = new CacheVerifyRecordDaoImpl();

    public static void main(String[] args) throws SQLException {
//        addCacheVerifyRecord();
//        updateCacheVerifyRecord();
//        deleteCacheVerifyRecord();
//        findCacheVerifyRecordById();
//        findAllCacheVerifyRecord();
//        findCacheVerifyRecordByBankName();
        cacheVerifyRecord();
    }

    /**
     * 根据银行名称查询
     *      1、已经建立索引, alter table tb_cache_verify_record add
     *      2、当数据量很大时(比如本表数据行数大于800万),建立索引的时间相当漫长。
     *      3、公司笔记本上操作，非服务器。
     *      4、5次查询时间记录： 40秒、42秒、42秒、40秒、42秒 /平均时间41.2秒
     */
    private static void findCacheVerifyRecordByBankName() throws SQLException {
        long startTime = System.currentTimeMillis();

        List<CacheVerifyRecord> records = dao.findCacheVerifyRecordByBankName("建设银行");
        // System.out.println(records);

        long endTime = System.currentTimeMillis();
        System.out.println("findCacheVerifyRecordByBankName查询到：" + records.size() + "条,共花费时间："
            + (endTime - startTime) / 1000 + "秒");

//         for (CacheVerifyRecord cacheVerifyRecord : records) {
//            System.out.println(cacheVerifyRecord);
//         }
    }

    /**
     * 统计(该表数据行数大于800万)
     *       mysql存储引擎,花费时间记录5次
     *       1、select count(*) from tb_cache_verify_record
     *          24秒、19秒、22秒、22秒、19秒 /平均时间：21.2秒
     *       2、select count(id) from tb_cache_verify_record
     *          26秒、13秒、21秒、25秒、20秒 /平均时间：21秒
     *       3、select count(1) from tb_cache_verify_record
     *          19秒、19秒、21秒、24秒、15秒 /平均时间：19.6秒
     * 高性能 MySQL 之 Count 统计查询，参考：
     * <a href="https://blog.csdn.net/vip_hitwu/article/details/77066688">...</a>
     */
    public static void cacheVerifyRecord() throws SQLException {
        long startTime = System.currentTimeMillis();

        long count = dao.cacheVerifyRecordCount();

        long endTime = System.currentTimeMillis();
        System.out.println("count数据行数：" + count + ",该方法共花费时间：" + (endTime - startTime) / 1000 + "秒");
    }

    /**
     * 查询所有
     *      查询时间大于10分钟，800万+的数据不是闹的，没有where用不上索引。
     *      优化措施：分库分表，你看着办吧!
     */
    public static void findAllCacheVerifyRecord() throws SQLException {
        long startTime = System.currentTimeMillis();

        List<CacheVerifyRecord> records = dao.findAll();
        // System.out.println(records);

        long endTime = System.currentTimeMillis();
        System.out.println(
            "findAllCacheVerifyRecord查询到：+ " + records.size() + "条,共花费时间：" + (endTime - startTime) / 1000 + "秒");
    }

    // 查询单个
    public static void findCacheVerifyRecordById() throws SQLException {
        CacheVerifyRecord record = dao.findById("00001c0521534ad282df290b95a6b887");
        System.out.println(record);
    }

    // 删除
    public static void deleteCacheVerifyRecord() throws SQLException {
        dao.delete("000022bfde43411596412682cd579316");
    }

    // 修改
    public static void updateCacheVerifyRecord() throws SQLException {
        // 先查询再修改
        CacheVerifyRecord record = dao.findById("00001c0521534ad282df290b95a6b887");
        record.setCardName("蒋志新2"); // 原来这条数据CardName=蒋志新
        dao.update(record);
    }

    // 新增
    public static void addCacheVerifyRecord() throws SQLException {
        CacheVerifyRecord record = new CacheVerifyRecord();
        record.setId("20180613");
        record.setCardName("西门吹雪");
        dao.add(record);
    }

}