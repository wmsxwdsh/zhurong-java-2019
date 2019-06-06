package com.zhurong.generator.persistence.mybatis.mapper.generic;

import com.zhurong.generator.persistence.mybatis.domain.TbCityInfo;
import com.zhurong.generator.persistence.mybatis.domain.TbCityInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCityInfoMapper {
    int countByExample(TbCityInfoExample example);

    int deleteByExample(TbCityInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCityInfo record);

    int insertSelective(TbCityInfo record);

    List<TbCityInfo> selectByExample(TbCityInfoExample example);

    TbCityInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCityInfo record, @Param("example") TbCityInfoExample example);

    int updateByExample(@Param("record") TbCityInfo record, @Param("example") TbCityInfoExample example);

    int updateByPrimaryKeySelective(TbCityInfo record);

    int updateByPrimaryKey(TbCityInfo record);
}