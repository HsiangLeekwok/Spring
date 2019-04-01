package com.enjoy.cap7.config;

import com.enjoy.cap1.Person;
import com.enjoy.cap7.bean.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <br>Author</br>: Hsiang Leekwok
 * <br>Date</br>: 2019/03/30 18:23
 * <br>Version</br>: v1.0
 * <br>Description</br>:
 */
@ComponentScan(value = "com.enjoy.cap7")
@Configuration
public class Cap7ConfigOfLifeCycle {
    @Bean
    public Person person() {
        System.out.println("给容器中添加person");
        return new Person("leek", 36);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Bike bike() {
        return new Bike();
    }
}
