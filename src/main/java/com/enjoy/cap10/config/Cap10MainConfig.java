package com.enjoy.cap10.config;

import com.enjoy.cap10.aop.Calculator;
import com.enjoy.cap10.aop.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/01 19:35<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>: 测试AOP切面
 */
@Configuration
@EnableAspectJAutoProxy
public class Cap10MainConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
