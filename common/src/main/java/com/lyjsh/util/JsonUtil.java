package com.lyjsh.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @Author wl
 * @Date 2018/6/24 0:00
 * @Todo 封装谷歌gson
 */

public class JsonUtil {

    private static Gson gson = new Gson();


    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T fromJson(String json,Class<T> type) {
        return gson.fromJson(json,type);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json,typeOfT);
    }

}
