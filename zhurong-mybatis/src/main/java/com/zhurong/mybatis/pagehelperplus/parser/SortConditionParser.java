package com.zhurong.mybatis.pagehelperplus.parser;

import com.zhurong.mybatis.pagehelperplus.SortCondition;
import java.util.List;

/**
 * 排序条件解析器
 * 2019/6/21
 */
public class SortConditionParser {

    public static String converToOrderBy(List<SortCondition> sortConditionList) {
        String orderBy = "";
        
        int size = sortConditionList.size();
        for(int i = 0; i < size; i++) {
            SortCondition sortCondition = sortConditionList.get(i);

            if(i == size - 1) {
                orderBy = orderBy + sortCondition.getProperty() + " " + sortCondition.getDirection();
            } else {
                orderBy = orderBy + sortCondition.getProperty() + " " + sortCondition.getDirection() + ",";
            }
        }

        return orderBy;
    }


}