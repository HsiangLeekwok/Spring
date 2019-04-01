package com.enjoy.cap5.config;

import com.enjoy.cap5.beans.Tiger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 17:48
 * Version: v1.0
 * Description: 通过 BeanDefinitionRegistrar 注册 bean 到 IOC 里
 */
public class ImportBeanDefinitionRegistrarTest implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 可以判断当某些条件允许时才加载某些bean
        boolean hasDog = registry.containsBeanDefinition("com.enjoy.cap5.beans.Dog");
        boolean hasCat = registry.containsBeanDefinition("com.enjoy.cap5.beans.Cat");
        if (hasCat && hasDog) {
            BeanDefinition definition = new RootBeanDefinition(Tiger.class);
            registry.registerBeanDefinition("tigerTest", definition);
        }
    }
}
