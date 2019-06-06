package com.zhurong.generator.service.impl;

import com.zhurong.db.persistence.domain.ProjectDataSource;
import com.zhurong.db.persistence.mapper.generic.ProjectDataSourceMapper;
import com.zhurong.generator.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NoBugNoCode
 *
 *         2019年2月28日 下午2:45:59
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {

	@Autowired
	private ProjectDataSourceMapper projectDataSourceMapper;

	/**
	 * @Description: 通过主键获取数据源（并进行密码解密）
	 * @param dataSourceId
	 * @return com.essence.edop.common.dto.EdopResponse
	 * @author LZG
	 * @date 2019/3/25
	 */
	@Override
	public ProjectDataSource getDataSourceById(String dataSourceId) {
		ProjectDataSource dbc = projectDataSourceMapper.selectByPrimaryKey(dataSourceId);
		return dbc;
	}


}
