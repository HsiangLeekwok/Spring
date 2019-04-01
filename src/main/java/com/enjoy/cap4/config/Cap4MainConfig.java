package com.enjoy.cap4.config;

import com.enjoy.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:38
 * Version: v1.0
 * Description: 配置类
 */
@Configuration
public class Cap4MainConfig {

    // 给容器中注册一个bean，类型为返回值的类型

    /**
     * 主要针对单实例bean(默认在容器启动的时候创建的对象叫单实例)
     * 懒加载：容器启动的时候不创建对象，仅当第一次使用(获取)bean的时候才创建对象
     */
    @Lazy
    @Bean
    public Person person() {
        System.out.println("给容器中添加person");
        return new Person("leek", 36);
    }
}
