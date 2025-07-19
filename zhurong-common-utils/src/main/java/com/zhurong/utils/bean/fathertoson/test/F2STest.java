package com.zhurong.utils.bean.fathertoson.test;

import com.zhurong.slb.util.fathertoson.F2SEntityUtil;
import com.zhurong.slb.util.fathertoson.entity.Dict;
import com.zhurong.slb.util.fathertoson.entity.DictVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2020年06月22日
 */
public class F2STest {

    public static void main(String[] args) {
//        testForce();
        testF2SEntityUtil();

    }

    private static void testF2SEntityUtil() {
        DictVO dictVO = new DictVO();
        List<Dict> dictLit = getDictLit();

        for (Dict element : dictLit) {
            dictVO = (DictVO) F2SEntityUtil.doJob(element, dictVO);
            dictVO.setCategoryName("身份证地区");
            dictVO.setDictNo((int) (Math.random() * 100)); //0-100的整数
            dictVO.setBlack(false);
            System.out.println(dictVO);
            System.out.println("-------------");
        }
        //不是extends关系的两个类调用会报错
//        F2SEntityUtil.doJob("123", dictVO);
    }

    /**
     * 强转是不行的。会报ClassCastException
     * @date 2020/6/22
     */
    private static void testForce() {
        List<DictVO> collect = getDictLit().stream().map(
                element -> (DictVO) element).collect(Collectors.toList());
    }


    public static List<Dict> getDictLit() {
        List<Dict> dictList = new ArrayList<>();

        Dict dict123 = new Dict();
        dict123.setId("123");
        dict123.setCategoryId("category123");
        dict123.setCode("code123");
        dict123.setName("name123");
        dict123.setDescription("description123");
        dict123.setSequence(123);

        Dict dict456 = new Dict();
        dict456.setId("456");
        dict456.setCategoryId("category456");
        dict456.setCode("code456");
        dict456.setName("name456");
        dict456.setDescription("description456");
        dict456.setSequence(456);

        dictList.add(dict123);
        dictList.add(dict456);

        return dictList;
    }

}