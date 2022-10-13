package autoWiredWithxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import constructorInjection.ConStudent;

public class MainClassBody {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("autowiredBasic.xml");
		Human hum = context.getBean("human",Human.class);
		hum.humanpump();
	
	}

}
