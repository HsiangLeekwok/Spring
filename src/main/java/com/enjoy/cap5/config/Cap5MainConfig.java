package com.enjoy.cap5.config;

import com.enjoy.cap1.Person;
import com.enjoy.cap5.beans.Cat;
import com.enjoy.cap5.beans.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:38
 * Version: v1.0
 * Description: 配置类
 */
@Configuration
@Import(value = {Dog.class, Cat.class, ImportSelectorTest.class, ImportBeanDefinitionRegistrarTest.class, FactoryBeanTest.class})
public class Cap5MainConfig {

    // 给容器中注册一个bean，类型为返回值的类型

    /**
     * 主要针对单实例bean(默认在容器启动的时候创建的对象叫单实例)
     * 懒加载：容器启动的时候不创建对象，仅当第一次使用(获取)bean的时候才创建对象
     */
    @Bean
    public Person person() {
        System.out.println("给容器中添加person");
        return new Person("leek", 36);
    }
}
