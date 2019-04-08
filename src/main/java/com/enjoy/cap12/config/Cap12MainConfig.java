package com.enjoy.cap12.config;

import com.enjoy.cap12.bean.Moon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/08 19:16<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
@Configuration
@ComponentScan("com.enjoy.cap12.processor")
public class Cap12MainConfig {

    @Bean
    public Moon getMoon() {
        return new Moon();
    }
}
