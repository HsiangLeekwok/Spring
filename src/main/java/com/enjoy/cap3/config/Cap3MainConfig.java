package com.enjoy.cap3.config;

import com.enjoy.cap1.Person;
import org.springframework.context.annotation.*;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:38
 * Version: v1.0
 * Description: 配置类
 */
@Configuration
public class Cap3MainConfig {

    // 给容器中注册一个bean，类型为返回值的类型

    /**
     * prototype：多实例，IOC启动的时候不会创建，只有在需要bean的时候才会创建
     * singleton：单实例（默认）：IOC启动的时候创建并放到ＩＯＣ容器中，以后每次获取的就是直接从IOC的Map容器中获取的同一个bean实例
     * request：主要针对web应用，递交一次请求创建一个实例
     * session：同一个session创建了一个实例
     */
    @Scope("prototype")
    @Bean
    public Person person() {
        return new Person("leek", 36);
    }
}
