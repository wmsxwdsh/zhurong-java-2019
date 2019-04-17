package com.zhurong.db.persistence.mapper.generic;

import com.zhurong.db.persistence.domain.ProjectDataSource;
import com.zhurong.db.persistence.domain.ProjectDataSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectDataSourceMapper {
    int countByExample(ProjectDataSourceExample example);

    int deleteByExample(ProjectDataSourceExample example);

    int deleteByPrimaryKey(String dataSourceId);

    int insert(ProjectDataSource record);

    int insertSelective(ProjectDataSource record);

    List<ProjectDataSource> selectByExample(ProjectDataSourceExample example);

    ProjectDataSource selectByPrimaryKey(String dataSourceId);

    int updateByExampleSelective(@Param("record") ProjectDataSource record, @Param("example") ProjectDataSourceExample example);

    int updateByExample(@Param("record") ProjectDataSource record, @Param("example") ProjectDataSourceExample example);

    int updateByPrimaryKeySelective(ProjectDataSource record);

    int updateByPrimaryKey(ProjectDataSource record);
}