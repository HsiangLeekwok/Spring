package com.enjoy.cap7.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * <br>Author</br>: Hsiang Leekwok
 * <br>Date</br>: 2019/03/30 19:07
 * <br>Version</br>: v1.0
 * <br>Description</br>: 通过initializingBean和DisposableBean接口实现bean的创建和销毁
 */
@Component
public class Train implements InitializingBean, DisposableBean {
    public Train() {
        System.out.println("Train constructor......");
    }

    // 当bean销毁时调用此方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Train destroy.......");
    }

    // 当bean初始化完成时调用此方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Train afterPropertiesSet.......");
    }
}
