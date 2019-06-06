/**   
 * @Title: TbCityInfoServiceImpl.java
 * @Package: com.zhurong.generator.persistence.mybatis
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package templates;

import com.zhurong.generator.persistence.mybatis.domain.TbCityInfo;
import com.zhurong.generator.persistence.mybatis.domain.TbCityInfoExample;
import com.zhurong.generator.persistence.mybatis.domain.TbCityInfoExample.Criteria;
import com.zhurong.generator.persistence.mybatis.mapper.generic.TbCityInfoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 
 * @author LZG
 * @date 2019/6/5
 */
@Service
public class TbCityInfoServiceImpl implements TbCityInfoService {

    @Autowired
    private TbCityInfoMapper tbCityInfoMapper;

    @Override
    public void insert(TbCityInfo record) {
        tbCityInfoMapper.insert(record);
    }

    @Override
    public void remove(Integer primaryKey) {
        tbCityInfoMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public void remove(List<Integer> primaryKeyList) {
        TbCityInfoExample example = new TbCityInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdIn(primaryKeyList);

        tbCityInfoMapper.deleteByExample(example);
    }

    @Override
    public void update(TbCityInfo record) {
        tbCityInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public TbCityInfo find(Integer primaryKey) {
        return tbCityInfoMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public List<TbCityInfo> findAll() {
        return tbCityInfoMapper.selectByExample(null);
    }

}