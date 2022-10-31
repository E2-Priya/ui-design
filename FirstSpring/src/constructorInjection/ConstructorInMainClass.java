package constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Basic.Phone;

public class ConstructorInMainClass {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("constructorIn.xml");
		ConStudent student = context.getBean("student",ConStudent.class);
		student.display();
	
	}

}

