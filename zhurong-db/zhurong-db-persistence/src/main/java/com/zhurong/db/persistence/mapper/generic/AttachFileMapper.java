package com.zhurong.db.persistence.mapper.generic;

import com.zhurong.db.persistence.domain.AttachFile;
import com.zhurong.db.persistence.domain.AttachFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttachFileMapper {
    int countByExample(AttachFileExample example);

    int deleteByExample(AttachFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(AttachFile record);

    int insertSelective(AttachFile record);

    List<AttachFile> selectByExample(AttachFileExample example);

    AttachFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AttachFile record, @Param("example") AttachFileExample example);

    int updateByExample(@Param("record") AttachFile record, @Param("example") AttachFileExample example);

    int updateByPrimaryKeySelective(AttachFile record);

    int updateByPrimaryKey(AttachFile record);
}