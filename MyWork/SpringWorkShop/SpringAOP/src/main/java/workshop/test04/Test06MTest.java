package workshop.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test06MTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Person student = ctx.getBean("student04", Person.class);
		student.homework();



	}

}
