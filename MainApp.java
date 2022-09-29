package Basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Be.xml");
		
		HelloWord obj = (HelloWord)ac.getBean("hw");
		obj.method();
		System.out.println("Welcome");

	}

}
