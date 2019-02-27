/**
 * @Title: TestPropertiesUtil.java
 * @Package: com.zhurong.utils.properties
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Test;

/**
 * @description: PropertiesUtil测试类
 * @author LZG
 * @date 2018/8/27
 */
public class TestPropertiesUtil {

    // 绝对路径读取
    @Test
    public void fromAbsolutePath() {
        //Properties properties = PropertiesUtil.readFromAbsolutePath("D:" + File.separator + "test1.properties");
        Properties properties = PropertiesUtil.readFromAbsolutePath("D:\\test1.properties");
        String companyAddress = properties.getProperty("company.address");
        System.out.println("fromAbsolutePath: " + companyAddress);
    }

    // 从此类所在的包下读取properties
    @Test
    public void fromCurrentPackage() {
        Properties properties = PropertiesUtil.read("test2.properties");
        String companyAddress = properties.getProperty("company.address");
        System.out.println("fromCurrentPackage: " + companyAddress);
    }

    // 从classpath根目录下读取properties(target下)
    @Test
    public void fromClasspath() {
        Properties properties = PropertiesUtil.read("/test3.properties");
        String companyAddress = properties.getProperty("company.address");
        System.out.println("fromClasspath: " + companyAddress);
    }

    // 从classpath的某目录下读取properties(target下)
    @Test
    public void fromClasspath2() {
        Properties properties = PropertiesUtil.read("/config/test4.properties");
        String companyAddress = properties.getProperty("company.address");
        System.out.println("fromClasspath2: " + companyAddress);
    }

    /**
     * @Description: 从src同级目录下读取properties
     *      Project
     *          --src
     *              --com
     *                  --java
     *                      --Client.java
     *          --config
     *              --dbConfig.properties
     *          --WebContent
     *              --WEB-INF
     *                  --lib
     *                  --dbConfig.properties
     *      特殊说明：想使用这个方法,必须是Web项目才可以，WebContent文件夹及下面的内容需要发布到classpath下
     * @return void
     * @author LZG
     * @date 2018/8/27
     */
    @Test
    public void fromNotSrcPath() throws Exception {
        String propPath = "WebContent/test5.properties";

        String path = TestPropertiesUtil.class.getClass().getResource("/").getPath();
        System.out.println(path);

        String websiteURL = (path.replace("/build/classes", "").replace("%20", " ").replace("classes/", "") + propPath)
            .replaceFirst("/", "");

        Properties prop = new Properties();
        InputStream is = new FileInputStream(websiteURL);
        prop.load(is);
        System.out.println("fromNotSrcPath: " + prop.getProperty("company.address"));
    }

}