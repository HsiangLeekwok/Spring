package com.enjoy.cap1.config;

import com.enjoy.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:25
 * Version: v1.0
 * Description: 注解，一个配置类，等于一个配置文件
 */
@Configuration
public class MainConfig {

    // 给容器中注册一个bean，类型为返回值的类型
    @Bean("person01")
    public Person person01() {
        return new Person("leek", 36);
    }
}
