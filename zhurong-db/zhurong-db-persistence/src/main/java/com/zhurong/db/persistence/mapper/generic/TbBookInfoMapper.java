package com.zhurong.db.persistence.mapper.generic;

import com.zhurong.db.persistence.domain.TbBookInfo;
import com.zhurong.db.persistence.domain.TbBookInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBookInfoMapper {
    int countByExample(TbBookInfoExample example);

    int deleteByExample(TbBookInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbBookInfo record);

    int insertSelective(TbBookInfo record);

    List<TbBookInfo> selectByExample(TbBookInfoExample example);

    TbBookInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBookInfo record, @Param("example") TbBookInfoExample example);

    int updateByExample(@Param("record") TbBookInfo record, @Param("example") TbBookInfoExample example);

    int updateByPrimaryKeySelective(TbBookInfo record);

    int updateByPrimaryKey(TbBookInfo record);
}