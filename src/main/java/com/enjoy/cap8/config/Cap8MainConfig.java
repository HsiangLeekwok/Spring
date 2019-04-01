package com.enjoy.cap8.config;

import com.enjoy.cap8.bean.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <br>Author</br>: Hsiang Leekwok
 * <br>Date</br>: 2019/03/30 18:23
 * <br>Version</br>: v1.0
 * <br>Description</br>: Cap8 的主配置
 */
@Configuration
@PropertySource(value = "classpath:/test.properties")
public class Cap8MainConfig {

    @Bean
    public Bird bird() {
        return new Bird();
    }
}
