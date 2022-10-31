package looseCoupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependencies.Student;

public class MainLooseCoupling {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("looseCoupling.xml");
		LooseCouplingStudent student = context.getBean("stu",LooseCouplingStudent.class);
		student.studentExam();
	
	}

}
