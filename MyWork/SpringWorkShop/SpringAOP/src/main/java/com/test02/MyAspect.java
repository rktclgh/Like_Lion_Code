package com.test02;

import org.aopalliance.intercept.MethodInterceptor; // 메소드 호출을 가로채기 한다음 부가 정보를 추가로 구현하는 인터페이스
import org.aopalliance.intercept.MethodInvocation;//실행되는 메소드가 있다면 정보를 담아서 저장하는 객체 -> 메소드 이름(매개인자)

public class MyAspect implements MethodInterceptor{


    @Override
    public Object invoke(MethodInvocation i) throws Throwable {
        System.out.println("method "+i.getMethod()+"is called on"+
                i.getThis()+" with args"+ i.getArguments());

Object ret = i.proceed();
        System.out.println("[AOP] 풀석 시작 확인 중..");

        System.out.println("[AOP] 줌인합니다. 출석 확인");
        try{
            ret=i.proceed();
        }catch(Exception e){
            System.out.println("[AOP] 오류 발생");
        }finally {
            System.out.println("[AOP] 강의 종료후 퇴실을 확인합니다");
        }
        System.out.println("[AOP] 줌 로그아웃 합니다.");

        System.out.println(("method "+i.getMethod()+"is returns"+ret));

        return ret;
    }
}
