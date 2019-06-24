/**   
 * @Title: SortConditionParser.java
 * @Package: com.zhurong.mybatis.pagehelper.util
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.mybatis.pagehelperplus.parser;

import com.zhurong.mybatis.pagehelperplus.SortCondition;
import java.util.List;

/**
 * @description: 排序条件解析器
 * @author LZG
 * @date 2019/6/21
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