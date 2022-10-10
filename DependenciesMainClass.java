package dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Basic.Phone;

public class DependenciesMainClass {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("dependency.xml");
		Student student = context.getBean("student",Student.class);
		student.display();
	
	}

}

