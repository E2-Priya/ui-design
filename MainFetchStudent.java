package studentInformation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;




public class MainFetchStudent {
public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		System.out.println("Done");
	
		
		    System.out.println("*************Enter number 1 to view***********");
			System.out.println("*************Enter number 2 for view in age order*************");
			System.out.println("*************Enter number 3 for inserting*************");
			System.out.println("*************Enter number 4 to edit *************");
			System.out.println("*************Enter number 5 to Sort by sub *************");
			
			
			
		

		int num;
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		MainFetchStudent mf = new MainFetchStudent();
		switch(num) {
		case 1:
			System.out.println("Alphabetic order ");
		    Criteria c = session.createCriteria(Student.class);
		    c.addOrder(Order.asc("studentName"));
		    List <Student> sd = c.list();
		    for(Student s:sd) {
			System.out.println(s);}
		
			break;
		case 2:
			System.out.println("Age order");
		    Criteria cage = session.createCriteria(Student.class);
		    cage.addOrder(Order.asc("age"));
		    List <Student> sage = cage.list();
		    for(Student s:sage) {
			System.out.println(s);}
		   
		case 3:
			Student sInsert = new Student();
			int id;
			String studentName;
			int age;
			int phone;
			String address;
			String gender;
			int subId;
			 
			 Scanner sc=new Scanner(System.in);
			 
			 
			 System.out.println("Enter student id");
			 id = sc.nextInt();
			 System.out.println("Enter student name");
			 studentName = sc.next();
			 System.out.println("Enter age");
			 age = sc.nextInt();
			 System.out.println("Enter phone");
			 phone = sc.nextInt();
			 System.out.println("Enter address");
			 address = sc.next();
			 System.out.println("Enter  gender");
			 gender = sc.next();
			 System.out.println("Enter sub id");
			 subId = sc.nextInt();
			 
			 sInsert.setId(id);
			 sInsert.setStudentName(studentName);
			 sInsert.setAge(age);
			 sInsert.setAddress(address);
			 sInsert.setPhone(phone);
			 sInsert.setGender(gender);
			 sInsert.setSubId(subId);
	        
	         session.save(sInsert);
	         System.out.println(session.save(sInsert));
	         System.out.println("rows affected");
	         t.commit();
	         session.close();
	         
		case 4:
			Student sEdit = new Student();
	        Scanner sE=new Scanner(System.in);
	        System.out.println("Enter the id u want to update");
	        int StduentId  = sE.nextInt();
	        
	      
			String EstudentName;
			int Eage;
			int Ephone;
			String Eaddress;
			String Egender;
			int EsubId;
			
			 System.out.println("Enter student name");
			 EstudentName = sE.next();
			 System.out.println("Enter age");
			 Eage = sE.nextInt();
			 System.out.println("Enter phone");
			 Ephone = sE.nextInt();
			 System.out.println("Enter address");
			 Eaddress = sE.next();
			 System.out.println("Enter  gender");
			 Egender = sE.next();
			 System.out.println("Enter sub id");
			 EsubId = sE.nextInt();
			
			
			Query q=session.createQuery("update Student s set s.studentName = '"+EstudentName+ "' , s.age ="+Eage+" , s.phone="+Ephone+" , s.address= '"+Eaddress+"' , s.gender='"+Egender+"'  , s.subId="+EsubId+" where id="+StduentId);   
			int result=q.executeUpdate();  
			System.out.println("rows affected "+result);  
			t.commit();  
	         session.close();
		
		case 5: 
			/*System.out.println("sub order");
		    Criteria cSub = session.createCriteria(Student.class);
		    cSub.addOrder(Order.asc("sub"));
		    List <Student> sSub = cSub.list();
		    for(Student s:sSub) {
			System.out.println(s);}*/
		    
		    int sub;
		    Scanner sS=new Scanner(System.in);
		    System.out.println("ENter the sub id 201,202,203");
		    sub = sS.nextInt();
		    
		    
			Criteria cr = session.createCriteria(Student.class);
			cr.add(Restrictions.eq("subId", sub));
			
			List<Student> results = cr.list();
			for (Student m : results)
				System.out.println(m);

		default:
			System.out.println("Enter valid Number");
		}}
}
