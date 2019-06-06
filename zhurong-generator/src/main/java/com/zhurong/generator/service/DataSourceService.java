package com.zhurong.generator.service;

import com.zhurong.db.persistence.domain.ProjectDataSource;

/**
 * 
 * @author NoBugNoCode
 *
 * 2019年2月28日 下午2:46:05
 */
public interface DataSourceService {

	/**
	 * @Description: 通过主键获取数据源
	 * @param dataSourceId
	 * @return com.essence.edop.common.dto.EdopResponse
	 * @author LZG
	 * @date 2019/3/25
	 */
	public ProjectDataSource getDataSourceById(String dataSourceId);

}
