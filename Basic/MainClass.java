package Basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("Be.xml");
		Phone phone = context.getBean("samsung",Phone.class);
		phone.call();
		phone.message();
		phone.colour();
	}

}
