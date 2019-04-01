package com.enjoy.cap1;

import com.enjoy.cap1.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:20
 * Version: v1.0
 * Description: 测试老式的 bean 类加载方式
 */
public class MainTest1 {

    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext app= new AnnotationConfigApplicationContext(MainConfig.class) ;
//        Person person= (Person) app.getBean("person");
//        System.out.println(person);
        String[]namesForBean=app.getBeanNamesForType(Person.class);
        for (String name : namesForBean) {
            System.out.println(name);
        }
    }
}
