package com.qfedu.utils;

import com.qfedu.entry.Json;

public class JsonSetUtils {
    private static Json json;
    public static Json getJson(String code, String msg, Object data) {
        json.setCode(code);
        json.setMsg(msg);
        json.setData(data);
        return json;
    }
}
