import java.util.List;
import java.util.Scanner;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.*;

public class DemoHib {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		
		
		// to view
		/*String hql = "from StudentDetails";
		Query query = session.createQuery(hql);

		List<StudentDetails> sd = query.list();
		for (StudentDetails student: sd) {
			System.out.println(student.getName());
			
		}
		*/
		
		
		// insert
		/*StudentDetails sd = new StudentDetails();
		 String name;
		 int id;
		 
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter name");
		 name = sc.next();
		 System.out.println("Enter ur id");
		 id = sc.nextInt();
         sd.setId(id);
         sd.setName(name);
         session.save(sd);
         System.out.println(session.save(sd));
         System.out.println("rows affected");
         tx.commit();
         session.close();*/
		
		
		// delete query
      /*  StudentDetails sd = new StudentDetails();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id u want to delete");
        int id  = sc.nextInt();
         Query query = session.createQuery("delete from StudentDetails where id ="+id);
         int result  = query.executeUpdate();
         tx.commit();
         session.close();
         System.out.println("rows affected"+result);*/
         
		
		
		//update
		/*StudentDetails sd = new StudentDetails();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id u want to update");
        int id  = sc.nextInt();
        System.out.println("Enter the name");
        String name = sc.next();
		Query q=session.createQuery("update StudentDetails s set s.name = '"+name+ "' where id="+id);   
		int result=q.executeUpdate();  
		System.out.println("rows affected "+result);  
		tx.commit();  
         session.close();*/
		
		 StudentDetails sd = new StudentDetails();
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter the id u want to delete");
	        int id  = sc.nextInt();
	         Query query = session.createQuery("delete from StudentDetails where id >"+id);
	         int result  = query.executeUpdate();
	         tx.commit();
	         session.close();
	         System.out.println("rows affected"+result);
	         
		
	}
}
