package templates;

import com.zhurong.generator.persistence.mybatis.domain.TbCityInfo;
import java.util.List;

public interface TbCityInfoService {

    void insert(TbCityInfo record);

    void remove(Integer primaryKey);
    void remove(List<Integer> primaryKeyList);

    void update(TbCityInfo record);


    TbCityInfo find(Integer primaryKey);
    List<TbCityInfo> findAll();
}
