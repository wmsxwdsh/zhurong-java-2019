package com.zhurong.generator.persistence.mybatis.mapper.generic;

import com.zhurong.generator.persistence.mybatis.domain.TbDictionary;
import com.zhurong.generator.persistence.mybatis.domain.TbDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDictionaryMapper {
    int countByExample(TbDictionaryExample example);

    int deleteByExample(TbDictionaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbDictionary record);

    int insertSelective(TbDictionary record);

    List<TbDictionary> selectByExample(TbDictionaryExample example);

    TbDictionary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbDictionary record, @Param("example") TbDictionaryExample example);

    int updateByExample(@Param("record") TbDictionary record, @Param("example") TbDictionaryExample example);

    int updateByPrimaryKeySelective(TbDictionary record);

    int updateByPrimaryKey(TbDictionary record);
}