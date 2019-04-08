package com.enjoy.cap12.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/08 19:20<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>: BeanFactoryPostProcessor 测试
 */
@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("TestBeanFactoryPostProcessor......." +
                "invoked method BeanFactoryPostProcessor.postProcessBeanFactory");
        // 所有 bean 的定义，已经加载到了 beanFactory 内，但实例还未创建
        int count = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前BeanFactory中有" + count + "个Bean：");
        for (String string : beanDefinitionNames) {
            System.out.println(string);
        }
    }
}
