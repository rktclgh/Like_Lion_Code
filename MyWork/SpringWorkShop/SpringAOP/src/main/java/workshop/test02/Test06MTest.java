package workshop.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test06MTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

//
//		System.out.println("====================================");
//
//		Student student = ctx.getBean("student6", Student.class);
//		System.out.println("학생 수업 시작");
//		student.classWork();
//		student.homework();
//		student.meeting("팀 프로젝트");
//
//		student.study();
//		student.relax();
//		student.eat("라면");
//		System.out.println(student.getScore());
//		((ClassPathXmlApplicationContext) ctx).close();


//		Person student = ctx.getBean("student02", Person.class);
//		student.study();

		Person student = ctx.getBean("student02", Person.class);
		student.getScore();



	}

}
