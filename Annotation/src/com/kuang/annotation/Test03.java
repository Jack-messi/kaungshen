package com.kuang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {

    //注解可以显示慰值，如果没有默认值，我们就必须给注解赋值
    @MyAnnotation2(name = "www",schools = "新欧冠屏幕大")
    public void test(){}

}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{

    //注解的参数：参数类型+类型名称（）;
    String name() default "";
    int age() default 0;
    int id() default -1;   //如果默认值为-1，代表不存在

    String[] schools() default {"北京大学","复旦大学"};

}

