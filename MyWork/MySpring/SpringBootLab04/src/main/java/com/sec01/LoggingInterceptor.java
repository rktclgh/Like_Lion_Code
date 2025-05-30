package com.sec01;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//HandlerInterceptor -> MVC 요청. 시작, 종료의 흐름을 가로채기 해서 로그를 해보자.

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(">>>> 요청 URL: "+request.getRequestURL());




        return true;// 계속 진행 할거야
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


        System.out.println("<<<<<<요청 완료 했어!!!");
    }
}
