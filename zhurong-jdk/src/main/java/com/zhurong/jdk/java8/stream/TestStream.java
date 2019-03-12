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

}