package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


//这个也会Spring容器托管，注册到容器中，因为他本来就是一个@Component，
// @Configuration代表这是一个配置类，
@Configuration
@ComponentScan("com.kuang.pojo")  //扫描包
@Import(KuangConfig2.class)
public class KuangConfig2 {

    //注册一个bean，就相当于我们之前写的一个bean标签
    //这个方法的名字(getUser)，就相当于bean标签中的id属性
    //这个方法的返回值，就相当于bean标签中的cLass属性
    @Bean
    public User getUser()
    {
        return new User(); //就是返回要注入到bean的对象！|
    }

}
