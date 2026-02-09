package com.zhurong.utils.response.edop;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 * EDOP 响应实体统一封装
 * 2019/3/13
 */
public class EdopResponse {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应状态
    private String code;

    //响应消息
    private String info;

    //响应的数据
    private Object result;

    public static EdopResponse build(String code, String info, Object result) {
        return new EdopResponse(code, info, result);
    }

    public static EdopResponse build(String code, String info) {
        return new EdopResponse(code, info, null);
    }

    public static EdopResponse ok(String info, Object data) {
        return new EdopResponse(ResponseEnum.server_ok.getCode(), info, data);
    }

    public static EdopResponse ok(String info) {
        return new EdopResponse(ResponseEnum.server_ok.getCode(), info);
    }

    public static EdopResponse error(String info, Object data) {
        return new EdopResponse(ResponseEnum.server_error.getCode(), info, data);
    }

    public static EdopResponse error(String info) {
        return new EdopResponse(ResponseEnum.server_error.getCode(), info);
    }

    public EdopResponse(String code, String info, Object result) {
        this.code = code;
        this.info = info;
        this.result = result;
    }

    public EdopResponse(String code, String info) {
        this.code = code;
        this.info = info;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 将json结果集转换为InfoCoinResponse对象
     * @param jsonData json数据
     * @param clazz InfoCoinResponse中的Object的类型
     * @return EdopResponse
     */
    public static EdopResponse formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, EdopResponse.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("result");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("code").asText(), jsonNode.get("info").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将json集合串转化成List<clazz>
     * @param jsonData
     * @param clazz
     * @return com.zshy.infocoin.service.common.EdopResponse
     */
    public static EdopResponse formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("result");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                    MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").asText(), jsonNode.get("info").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "EdopResponse{" +
            "code='" + code + '\'' +
            ", info='" + info + '\'' +
            ", result=" + result +
            '}';
    }

}