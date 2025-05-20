package Spring03.com.person.controller;

import com.person.config.AppConfig;
import com.person.controller.PersonController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonController controller = ctx.getBean(PersonController.class);

		controller.run();
		((AbstractApplicationContext)ctx).close();
	}

}
