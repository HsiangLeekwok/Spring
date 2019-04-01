package com.enjoy.cap7.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <br>Author</br>: Hsiang Leekwok
 * <br>Date</br>: 2019/03/30 19:16
 * <br>Version</br>: v1.0
 * <br>Description</br>:
 */
@Component
public class Jeep {

    public Jeep() {
        System.out.println("Jeep constructor.....");
    }

    @PostConstruct
    public void init() {
        System.out.println("Jeep init........");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Jeep destroy......");
    }
}
