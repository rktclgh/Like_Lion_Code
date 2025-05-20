package workshop.test09;

import java.lang.annotation.*;


@Target(ElementType.METHOD)//메서드에만 붙일 수 있음
@Retention(RetentionPolicy.RUNTIME) //런타임 유지 → AOP 감지 가능
@Documented //
public @interface LogExecution {
}



