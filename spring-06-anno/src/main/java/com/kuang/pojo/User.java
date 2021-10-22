package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//@component：组件，放在类上，说明这个类被Spring管理了，就是bean！
// 等价于<bean id="user" class="com.kuang.pojo"/>
// @Component 组件,@Component 代替了注册bean。 作用域，@Scope("prototype")代替了。注入值：@Value("张学友")代替了
@Component
@Scope("prototype")
public class User {

//    public String name="刘德华";

//    //这里相当于 <property name="name" value="张学友"/>
//    @Value("张学友")
    public String name;

//    public String getName() {
//        return name;
//    }

    //这里相当于 <property name="name" value="张学友"/>
    @Value("张学友")
    public void setName(String name) {
        this.name = name;
    }
}
