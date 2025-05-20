package workshop.test03;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "workshop.test03")
@EnableAspectJAutoProxy // AOP 프록시 자동 생성 허용
public class AppConfig {

}
