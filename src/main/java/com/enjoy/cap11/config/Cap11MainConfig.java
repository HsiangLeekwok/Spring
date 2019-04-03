package com.enjoy.cap11.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/03<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Description</b>: 主配置文件
 */

/**
 * InfrastructureAdvisorAutoProxyCreator
 * 1、注册
 * 2、利用后置处理器机制在创建以后包装对象，返回一个代理对象(增强)。代理对象执行方法时，利用拦截器链进行调用
 */
@Configuration
@ComponentScan({"com.enjoy.cap11"})
@EnableTransactionManagement// 开启事务管理功能
public class Cap11MainConfig {
    // 创建数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        // 这个 C3P0 封装了JDBC DataSource接口的实现
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    /**
     * JDBC template 能简化增删改查操作
     */
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }

    /**
     * 注册事务管理器
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
