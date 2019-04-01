package com.enjoy.cap8.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/03/31 18:36<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
public class Bird {

    /**
     * 可以使用 @Value 进行赋值
     * 1、基本字符
     * 2、springEL表达式
     * 3、读取配置文件
     */
    @Value("Leekwok")
    private String name;
    @Value("#{20+3}")
    private Integer age;
    @Value("${bird.color}")
    private String color;

    public Bird() {
    }

    public Bird(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
