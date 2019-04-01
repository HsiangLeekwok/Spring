package com.enjoy.cap5.config;

import com.enjoy.cap5.beans.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * <b>Author</b>: Hsiang Leekwok <br/>
 * <b>Date</b>: 2019/03/30 18:01 <br/>
 * <b>Version</b>: v1.0 <br/>
 * <b>Description</b>: 通过 FactoryBean 回调实现加 bean 入 IOC
 */
public class FactoryBeanTest implements FactoryBean<Monkey> {
    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
