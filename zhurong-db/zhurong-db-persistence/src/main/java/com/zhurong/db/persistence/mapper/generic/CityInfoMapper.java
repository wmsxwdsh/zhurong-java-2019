package com.zhurong.db.persistence.mapper.generic;

import com.zhurong.db.persistence.domain.CityInfo;
import com.zhurong.db.persistence.domain.CityInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityInfoMapper {
    int countByExample(CityInfoExample example);

    int deleteByExample(CityInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityInfo record);

    int insertSelective(CityInfo record);

    List<CityInfo> selectByExample(CityInfoExample example);

    CityInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityInfo record, @Param("example") CityInfoExample example);

    int updateByExample(@Param("record") CityInfo record, @Param("example") CityInfoExample example);

    int updateByPrimaryKeySelective(CityInfo record);

    int updateByPrimaryKey(CityInfo record);
}