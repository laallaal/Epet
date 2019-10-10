package com.qfedu.utils;

import com.qfedu.entry.Json;

public class JsonSetUtils {

    public static Json getJson(String code, String msg, Object data) {
        Json json = new Json();
        json.setCode(code);
        json.setMsg(msg);
        json.setData(data);
        return json;
    }
}
