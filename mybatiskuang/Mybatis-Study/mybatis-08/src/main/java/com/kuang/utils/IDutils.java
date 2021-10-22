package com.kuang.utils;


//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import java.util.UUID;

@SuppressWarnings("all")  // 抑制警告
public class IDutils {

    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            System.out.println(IDutils.getId());
        }

    }
}
