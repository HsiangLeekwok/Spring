package com.enjoy.cap10.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * <b>Author</b>: 小果<br/>
 * <b>Date</b>: 2019/04/01 19:36<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>: AOP 切面实现类
 */
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.enjoy.cap10.aop.Calculator.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void beforeExecute(JoinPoint point) {
        System.out.println(point.getSignature().getName() + "'s before execute........parameters: " + Arrays.asList(point.getArgs()));
    }

    @After("pointCut()")
    public void afterExecute(JoinPoint point) {
        System.out.println(point.getSignature().getName() + "'s after execute..........");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("after returning.........result: " + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowing(Exception exception) {
        System.out.println("after throwing.......exception: {" + exception + "}");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around begin..............");
        // 这里相当于调用了目标方法进行执行
        Object object = point.proceed();
        System.out.println("around end...............");
        return object;
    }
}
