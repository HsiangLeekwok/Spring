package com.enjoy.cap10.aop;

/**
 * <b>Author</b>: 小果<br/>
 * <b>Date</b>: 2019/04/01 19:36<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>: 被 AOP 切分的类及其方法
 */
public class Calculator {

    public int div(int i, int j) {
        System.out.println("div method begin...............");
        int result = i / j;
        System.out.println("div method end..............");
        return result;
    }
}
