package com.enjoy.cap7.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/03/31 17:19<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
@Component
public class Plan implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Plan() {
        System.out.println("Plan constructor.....");
    }

    @PostConstruct
    public void init() {
        System.out.println("Plan init........");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Plan destroy......");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("Plan setApplicationContext.....");
    }
}