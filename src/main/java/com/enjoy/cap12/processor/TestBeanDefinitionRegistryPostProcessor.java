package com.enjoy.cap12.processor;

import com.enjoy.cap12.bean.Moon;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/08 19:51<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
@Component
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("TestBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry(), " +
                "共有" + registry.getBeanDefinitionCount() + "个bean");
//        RootBeanDefinition rbd = new RootBeanDefinition(Moon.class);
        AbstractBeanDefinition rbd = BeanDefinitionBuilder.rootBeanDefinition(Moon.class).getBeanDefinition();
        registry.registerBeanDefinition("hello", rbd);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("TestBeanDefinitionRegistryPostProcessor.postProcessBeanFactory(), " +
                "共有" + beanFactory.getBeanDefinitionCount() + "个bean");
    }
}
