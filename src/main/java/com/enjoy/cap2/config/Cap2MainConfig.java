package com.enjoy.cap2.config;

import com.enjoy.cap1.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:38
 * Version: v1.0
 * Description: 配置类
 */
@Configuration
@ComponentScan(value = "com.enjoy.cap2", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
public class Cap2MainConfig {

    // 给容器中注册一个bean，类型为返回值的类型
    public Person person() {
        return new Person("leek", 36);
    }
}