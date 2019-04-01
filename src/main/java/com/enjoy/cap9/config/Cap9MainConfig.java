package com.enjoy.cap9.config;

import com.enjoy.cap9.dao.TestDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <b>Author</b>: Hsiang Leekwok
 * <b>Date</b>: 2019/03/30 18:23
 * <b>Version</b>: v1.0
 * <b>Description</b>: Cap9 的主配置
 */
@Configuration
@ComponentScan({"com.enjoy.cap9.controller", "com.enjoy.cap9.service", "com.enjoy.cap9.dao"})
public class Cap9MainConfig {

    //    @Primary // spring进行自动装配的时候默认首选的bean
    @Bean("testDao2")
    public TestDao testDao() {
        TestDao dao = new TestDao();
        dao.setFlag("2");
        return dao;
    }
}
