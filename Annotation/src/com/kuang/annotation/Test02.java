package com.kuang.annotation;

import java.lang.annotation.*;


//测试元注解
public class Test02 {
    @Myannotation
    public void test(){

    }
}


// 定义一个注解
// Target 表示我们的注解可以用在什么地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})

// Retention 表示我们的注解在什么地方还有效
@Retention(value = RetentionPolicy.RUNTIME)

// Documented 表示是否将我们的注解生成在Javadoc中
@Documented

// 子类可以继承父类的注解
@Inherited

@interface Myannotation{

}



