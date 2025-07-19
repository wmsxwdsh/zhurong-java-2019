/**   
 * @Title: YkxbUtil.java
 * @Package: com.zhurong.utils.math
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.math;

import java.math.BigDecimal;

/**
 * @description: 二分插值y=kx+b工具类
 * @author LZG
 * @date 2019/2/28
 */
public class YkxbUtil {

    /**
     * @Description: 根据y求x的差值
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param y
     * @return java.math.BigDecimal x 保留两位小数
     * @author LZG
     * @date 2019/2/28
     */
    public final static BigDecimal doCalcXByY(BigDecimal x1, BigDecimal y1, BigDecimal x2, BigDecimal y2, BigDecimal y) {
        //x1=x2时无需插值
        if(x1.equals(x2)) {
            return x1;
        }

        BigDecimal k, b, x;

        //k=﹙y1－y2﹚／﹙x1－x2﹚
        //b=﹙y2x1－y1x2﹚／﹙x1－x2﹚
        k = (y1.subtract(y2)).divide(x1.subtract(x2), 3, BigDecimal.ROUND_HALF_UP);
        b = ( y2.multiply(x1).subtract(y1.multiply(x2))).divide(x1.subtract(x2), 3, BigDecimal.ROUND_HALF_UP);

        x = y.subtract(b).divide(k, 2 ,BigDecimal.ROUND_HALF_UP);
        return x;
    }

    //test: y=1.56x + 2.33
    public static void main(String[] args) {
        BigDecimal x1 = new BigDecimal(1);
        BigDecimal y1 = new BigDecimal(3.89);
        BigDecimal x2 = new BigDecimal(2);
        BigDecimal y2 = new BigDecimal(5.45);
        BigDecimal y = new BigDecimal(7.01);

        BigDecimal x = YkxbUtil.doCalcXByY(x1, y1, x2, y2, y);
        System.out.println(x.intValue()); //3
    }

}