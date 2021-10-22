package com.kuang.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
/*
* Utils工具类（新建utils包）
* 调用方式：类名.方法(时间对象)
* 返回Json格式时间
* */

public class JsonUtils {

    public static String getJson(Object object)
    {
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }
    public static String getJson(Object object,String dataFormat)
    {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        //定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);
        //指定日期格式
        mapper.setDateFormat(sdf);
        try {
            //将对象解析成为json格式
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
