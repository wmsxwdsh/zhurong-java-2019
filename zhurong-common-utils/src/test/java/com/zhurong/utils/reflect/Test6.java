package com.zhurong.utils.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: Blankj
 *     time  : 2018/01/12
 *     desc  :
 * </pre>
 */
public class Test6 {
    public Map<String, String> map = new HashMap<String, String>();

    public void put(String name, String value) {
        map.put(name, value);
    }
}
