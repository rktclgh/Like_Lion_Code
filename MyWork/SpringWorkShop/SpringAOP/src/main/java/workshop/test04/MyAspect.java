package workshop.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MyAspect {
//    @Pointcut("execution(* workshop.test01.Student.*(..))")
//    public void allMethods(){}// 가안으로 대처할 수 있는 포인트 컷이 있는 메소드를 만들어 준다.
//

//   @Before("allMethods()" )
//    public void before(JoinPoint joinPoint)
//    {
//        System.out.println("[AOP] 메서드 실행 전: "+ joinPoint.getSignature().getName());
//    }
//
//
//    public void after(JoinPoint joinPoint)
//    {
//        System.out.println("[AOP] 메서드 실행 후 : "+ joinPoint.getSignature().getName());
//    }


    @Before("execution(* workshop.test04.Student.study(..))")
    public void beforeStudy(JoinPoint joinPoint) {
        System.out.println("[AOP] 공부 시작합니다.");
    }


    @After("execution(* workshop.test04.Student.getScore(..))")
    public void afterScore(JoinPoint joinPoint) {
        System.out.println("[AOP] 점수 저장 완료");


    }  @Before("execution(* workshop.test04.Student.eat(..))")
    public void beforeEat(JoinPoint joinPoint) {

        String food = (String) joinPoint.getArgs()[0];
        System.out.println("[AOP]먹을 준비 완료: "+ food);
    }

    @After("execution(* workshop.test04.Student.homework(..))")
    public void afterHomework(JoinPoint joinPoint) {
        System.out.println("[AOP] 과제 오류 발생: 파일 오류");
    }





}
