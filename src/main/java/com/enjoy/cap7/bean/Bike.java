package com.enjoy.cap7.bean;

/**
 * <br>Author</br>: Hsiang Leekwok
 * <br>Date</br>: 2019/03/30 18:25
 * <br>Version</br>: v1.0
 * <br>Description</br>: Bean的初始化和销毁方法
 */
public class Bike {

    public Bike() {
        System.out.println("Bike constructor...");
    }

    public void init() {
        System.out.println("Bike init.....");
    }

    public void destroy() {
        System.out.println("Bike destroy....");
    }
}
