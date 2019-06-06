/**   
 * @Title: TbCityInfoService.java
 * @Package: com.zhurong.generator.persistence.mybatis
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京中数合一科技有限公司
 */
package templates;

import com.zhurong.generator.persistence.mybatis.domain.TbCityInfo;
import java.util.List;

/**
 * @description: 
 * @author LZG
 * @date 2019/6/5
 */
public interface TbCityInfoService {

    void insert(TbCityInfo record);

    void remove(Integer primaryKey);
    void remove(List<Integer> primaryKeyList);

    void update(TbCityInfo record);


    TbCityInfo find(Integer primaryKey);
    List<TbCityInfo> findAll();
}
