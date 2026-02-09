package com.zhurong.utils.response.s12366;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020年06月15日
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        this.put((String)"code", 1);
        this.put((String)"msg", "success");
    }

    public static R error() {
        return error(-1, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(-1, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put((String)"code", code);
        r.put((String)"msg", msg);
        return r;
    }

    public static R error(int code, String msg, String requestId) {
        R r = new R();
        r.put((String)"code", code);
        r.put((String)"msg", msg);
        r.put((String)"requestId", requestId);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        R r = new R();
        r.put((String)"msg", msg);
        return r;
    }

    public static R ok(Object obj) {
        R r = new R();
        r.put("data", obj);
        return r;
    }

    public static R page(Object obj) {
        R r = new R();
        Map<String, Object> data = new HashMap();
        data.put("page", obj);
        r.put((String)"data", data);
        return r;
    }

    public static R list(Object obj) {
        R r = new R();
        Map<String, Object> data = new HashMap();
        data.put("list", obj);
        r.put((String)"data", data);
        return r;
    }

    public static R ok(String msg, Object obj) {
        R r = new R();
        r.put((String)"msg", msg);
        r.put("data", obj);
        return r;
    }

    public static R ok(String msg, String key, Object value) {
        R r = new R();
        r.put((String)"msg", msg);
        Map<String, Object> data = new HashMap();
        data.put(key, value);
        r.put((String)"data", data);
        return r;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}