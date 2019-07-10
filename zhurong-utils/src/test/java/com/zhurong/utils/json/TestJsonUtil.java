/**   
 * @Title: TestJsonUtil.java
 * @Package: com.zhurong.utils.json
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.json;

import java.util.List;
import org.junit.Test;

/**
 * @description: 
 * @author LZG
 * @date 2019/7/10
 */
public class TestJsonUtil {

    @Test
    public void test() {
        String json = "[\n"
            + "\t{\n"
            + "\t\t\"paramName\": \"inCreateLineRasterRiverNetworkAbsolutePath\",\n"
            + "\t\t\"useItemIndexOutput\": 7,\n"
            + "\t\t\"useItemIndexParamName\": \"outCreateLineRasterRiverNetworkAbsolutePath\",\n"
            + "\t\t\"paramType\": \"in\",\n"
            + "\t\t\"outFileName\": \"\",\n"
            + "\t\t\"fileSuffix\": \"tif\"\n"
            + "\t},\n"
            + "\t{\n"
            + "\t\t\"paramName\": \"inRepeatCalculateFlowAbsolutePath\",\n"
            + "\t\t\"useItemIndexOutput\": 4,\n"
            + "\t\t\"useItemIndexParamName\": \"outRepeatCalculateFlowAbsolutePath\",\n"
            + "\t\t\"paramType\": \"in\",\n"
            + "\t\t\"outFileName\": \"\",\n"
            + "\t\t\"fileSuffix\": \"tif\"\n"
            + "\t},\n"
            + "\t{\n"
            + "\t\t\"paramName\": \"outCreateVectorRiverNetworkAbsolutePath\",\n"
            + "\t\t\"useItemIndexOutput\": 0,\n"
            + "\t\t\"useItemIndexParamName\": \"\",\n"
            + "\t\t\"paramType\": \"out\",\n"
            + "\t\t\"outFileName\": \"step9\",\n"
            + "\t\t\"fileSuffix\": \"shp\"\n"
            + "\t}\n"
            + "]";
        List<StaticMethodParamDto> staticMethodParamDtoList = JsonUtil.jsonToList(json, StaticMethodParamDto.class);

        for(StaticMethodParamDto s : staticMethodParamDtoList) {
            System.out.println(s);
        }
    }

}