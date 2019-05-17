/**
 * @Title: TestStream.java
 * @Package: com.zhurong.jdk.java8.stream
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jdk.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @description: 处理集合的优雅姿势 ——stream
 * @author LZG
 * @date 2019/3/12
 */
public class TestStream {

    //1、stream的创建
    @Test
    public void test1() {

        //1、通过已有的集合创建流（常用的）
        List<String> nameList = Arrays.asList("叶孤城", "西门吹雪", "司空摘星");
        Stream<String> stream1 = nameList.stream();

        //2、
        Stream<String> stream2 = Stream.of("叶孤城", "西门吹雪", "司空摘星");
    }

    //2、stream的中间操作filer、map、limit/skip、sorted、distinct
    @Test
    public void test2() {
        //(1)、filter用于通过设置的条件过滤出元素
        List<String> strList1 = Arrays.asList("hello", "world", "helloWorld");
        strList1.stream().filter(element -> element.startsWith("h")).forEach(element -> System.out.println(element));
        strList1.stream().filter(element -> element.endsWith("o")).forEach(System.out::println);
        //System.out::println 可以看作 lambda表达式 e -> System.out.println(e) 的缩写形式
    }

    @Test
    public void test3() {
        //(2)、map用于映射每个元素到对应的结果
        List<Integer> numberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numberList.stream().map(i -> i * i).forEach(System.out::println);
        //9,4,4,9,49,9,25
    }

    @Test
    public void test4() {
        //(3)、limit返回Stream的前面n个元素；skip 则是扔掉前 n 个元素。
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().limit(4).forEach(System.out::println);
        //3,2,2,3
    }

    @Test
    public void test5() {
        //(4)、sorted 方法用于对流进行排序
        List<Integer> numberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numberList.stream().sorted().forEach(System.out::println);
        //2,2,3,3,3,5,7
    }

    @Test
    public void test6() {
        //(5)、distinct主要用来去重
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().distinct().forEach(System.out::println);
        //3,2,7,5
    }


    //3、stream的最终操作forEach、count、collect
    //forEach就不说了，上面的都是
    @Test
    public void test7() {
        //(2)、count用来统计流中的元素个数
        List<String> strList = Arrays.asList("java", "php", "python", "ios", "c");
        System.out.println(strList.stream().count());
    }

    @Test
    public void test8() {
        //(3)、collect将流中的元素累积成一个汇总结果
        List<String> strList = Arrays.asList("java", "php", "python", "ios", "c");
        //可以用原来的strList接收，也可以再新建一个List<String> strList2来接收
        strList = strList.stream().filter(element -> element.startsWith("p")).collect(Collectors.toList());
        strList.forEach(System.out::println);
    }

    //-----实用例子start-----------------------------------
    //1、java8替代for循环的写法
    @Test
    public void test9() {
        /*
        List<ProjectDataSource> findAllDataSource = dataSourceService.findAllDataSource(paginatorParam);
        findAllDataSource.stream().filter(element -> {
            element.setDbPassword(AESUtil.decrypt(element.getDbPassword(), SysConstant.data_source_password_salt));
            return true;
        }).collect(Collectors.toList());
        return EdopResponse.ok("数据源查询成功!", findAllDataSource);
        */
    }

    //2、取某个List<Bean>的bean的某个属性成为集合
    @Test
    public void test10() {
        /*
        List<PubUserRoleKey> pubUserRoleList = pubUserRoleKeyService.getPubUserRoleList(userId);
        List<String> roleIdList = pubUserRoleList.stream().map(element -> element.getRoleId()).collect(Collectors.toList());
        */
    }

    //3、得到一个List<PubUser>，PubUser里面只有用户id。但这个user需要加个所属部门id和部门名称，部门id在另一张，部门名称在另另一张表。进行如下处理
    @Test
    public void test11() {
        /*
         List<PubUser> resultPubUserList = pubUserMapper.selectByExample(example);

        //处理机构名称显示
        resultPubUserList = resultPubUserList.stream().filter(element -> {
            PubUserCorpKey pubUserCorpKey = pubUserCorpKeyService.getPubUserCorpKeyListByUserId(element.getUserId());

            if(null != pubUserCorpKey) {
                String corpId = pubUserCorpKey.getCorpId();
                String corpName = pubCorpService.getPubCorpByCorpId(corpId).getCorpName();
                element.setCorpId(corpId);
                element.setCorpName(corpName);
            } else {
                PubCorp pubCorp = pubCorpService.getRootCorp();
                element.setCorpId(pubCorp.getCorpId());
                element.setCorpName(pubCorp.getCorpName());
            }
            return true;
        }).collect(Collectors.toList());
        */
    }



    //-----实用例子start-----------------------------------

}