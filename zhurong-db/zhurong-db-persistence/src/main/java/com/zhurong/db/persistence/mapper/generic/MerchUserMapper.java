package com.zhurong.db.persistence.mapper.generic;

import com.zhurong.db.persistence.domain.MerchUser;
import com.zhurong.db.persistence.domain.MerchUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchUserMapper {
    public static final String DATA_SOURCE_NAME = "db6";

    int countByExample(MerchUserExample example);

    int deleteByExample(MerchUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(MerchUser record);

    int insertSelective(MerchUser record);

    List<MerchUser> selectByExample(MerchUserExample example);

    MerchUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MerchUser record, @Param("example") MerchUserExample example);

    int updateByExample(@Param("record") MerchUser record, @Param("example") MerchUserExample example);

    int updateByPrimaryKeySelective(MerchUser record);

    int updateByPrimaryKey(MerchUser record);

    int insertBatch(List<MerchUser> records);

    List<MerchUser> selectByBigOffset(MerchUserExample example);
}