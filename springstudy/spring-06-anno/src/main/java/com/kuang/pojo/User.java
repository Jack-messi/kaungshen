package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
//    public String name = "刘丹丹";

    @Value("宋丹丹")
    public String name ;
}
