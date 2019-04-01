package com.enjoy.cap7.bean;

import com.enjoy.cap1.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <br>Author</br>: Hsiang Leekwok
 * <br>Date</br>: 2019/03/30 19:27
 * <br>Version</br>: v1.0
 * <br>Description</br>: 通过后置处理器方式增强bean
 */
@Component
public class BeanPostProcessorTest implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 返回一个对象(传过来的对象)
        // 在初始化方法调用之前进行后置处理工作
        // 在 initMethod = init 之前调用
        System.out.println("postProcessAfterInitialization..." + bean.getClass().getName());
        if (bean instanceof Person) {
            Person person = (Person) bean;
            person.setAge(55);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..." + bean.getClass().getName());
        return bean;
    }
}
