package objectInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjMainClass {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("objInjection.xml");
		ObjCollege obj = context.getBean("objCollege",ObjCollege.class);
		obj.deptName();
	}

}
