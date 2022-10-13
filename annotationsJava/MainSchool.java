package annotationsJava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSchool {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SchoolConfig.class);
		System.out.println("School configred");
		School sch = context.getBean("school",School.class);
	
		sch.schoolMethod();

	}

}
