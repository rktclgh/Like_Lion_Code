package com.test03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component

public class MyAspect {

    @Before("execution(public void com.test03.*.classWork(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("[AOP] 줌인 합니다. 출석 확인"+joinPoint.toString());
    }

    @AfterThrowing(pointcut = "execution(public void com.test03.*.classWork(..))", throwing = "e")
    public void throwing(JoinPoint joinPoint, Throwable e) {
        System.out.println("[AOP] 학습 중 오류가 발생했습니다.");
    }

    @After("execution(public void com.test03.*.classWork(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("[AOP] 줌 로그아웃 합니다.");
    }


//    @Override
//    public Object invoke(MethodInvocation i) throws Throwable {
//        System.out.println("method "+i.getMethod()+"is called on"+
//                i.getThis()+" with args"+ i.getArguments());
//
//Object ret = i.proceed();
//        System.out.println("[AOP] 풀석 시작 확인 중..");
//
//        System.out.println("[AOP] 줌인합니다. 출석 확인");
//        try{
//            ret=i.proceed();
//        }catch(Exception e){
//            System.out.println("[AOP] 오류 발생");
//        }finally {
//            System.out.println("[AOP] 강의 종료후 퇴실을 확인합니다");
//        }
//        System.out.println("[AOP] 줌 로그아웃 합니다.");
//
//        System.out.println(("method "+i.getMethod()+"is returns"+ret));
//
//        return ret;
//    }
}
