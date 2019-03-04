/**   
 * @Title: InfoCoinResponse.java
 * @Package: com.zhurong.utils.response
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 * @description: InfoCoin项目响应实体
 *      --InfoCoinResponse > XxxResult
 * @author LZG
 * @date 2018/11/6
 */
public class InfoCoinResponse {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应状态
    private String statusCode;

    //响应消息
    private String msg;

    //响应的数据
    private Object data;

    public static InfoCoinResponse build(String statusCode, String msg, Object data) {
        return new InfoCoinResponse(statusCode, msg, data);
    }

    public static InfoCoinResponse build(String statusCode, String msg) {
        return new InfoCoinResponse(statusCode, msg, null);
    }

    public static InfoCoinResponse build(ResponseEnum responseEnum, Object data) {
        return new InfoCoinResponse(responseEnum.getStatusCode(), responseEnum.getMsg(), data);
    }

    public static InfoCoinResponse build(ResponseEnum responseEnum) {
        return new InfoCoinResponse(responseEnum.getStatusCode(), responseEnum.getMsg(), null);
    }

    //参数
    public static InfoCoinResponse build(ResponseEnum responseEnum, String param) {
        return new InfoCoinResponse(responseEnum.getStatusCode(), param + responseEnum.getMsg(), null);
    }


    public static InfoCoinResponse ok(Object data) {
        return new InfoCoinResponse(data);
    }

    public static InfoCoinResponse ok() {
        return new InfoCoinResponse(null);
    }

    public InfoCoinResponse() {

    }

    public InfoCoinResponse(String statusCode, String msg, Object data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public InfoCoinResponse(Object data) {
        this.statusCode = "200";
        this.msg = "OK";
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @Description: 将json结果集转换为InfoCoinResponse对象
     * @param jsonData json数据
     * @param clazz InfoCoinResponse中的Object的类型
     * @return InfoCoinResponse
     * @author LZG
     * @date 2018/9/27
     */
    public static InfoCoinResponse formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, InfoCoinResponse.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("statusCode").asText(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @Description: 将json集合串转化成List<clazz>
     * @param jsonData
     * @param clazz
     * @return InfoCoinResponse
     * @author LZG
     * @date 2018/9/27
     */
    public static InfoCoinResponse formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                    MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("statusCode").asText(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }


}