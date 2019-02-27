/**
 * @Title: XmlUtil.java
 * @Package: com.zhurong.utils.xml
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.xml;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @description: 操作XML的工具类
 * @author LZG
 * @date 2018/8/27
 */
public class XmlUtil {

    /**
     * @Description: Xml转换为Obj
     * @param xml xml字符串
     * @param c 要转换的类型(XXX.class)
     * @return T 具体的JavaBean
     * @author LZG
     * @date 2018/8/27
     */
    public static <T> T convertXmlToEntity(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * @Description: Obj转换为xml字符串
     * @param obj
     * @param prefix 构建前缀信息 (如: <?xml version="1.0" encoding="UTF-8"?>)
     * @param endFix 后缀信息
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/27
     */
    public static String convertObjToXmlStr(Object obj, String prefix, String endFix) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();

            //决定是否在转换成xml时同时进行格式化（即按标签自动换行，否则即是一行的xml）
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //xml的编码方式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //不用带xml头信息
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            writer.write(prefix);
            marshaller.marshal(obj, writer);
            writer.write(endFix);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }



}