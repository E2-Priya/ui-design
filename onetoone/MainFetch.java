package onetoone;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import practise.College;

public class MainFetch {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		/*String hql = "from Address";
		Query query = session.createQuery(hql);
		
		System.out.println("hello");

		List<Address> sd = query.list();
		System.out.println("Employee id    Employee first name    E<ployee last name    Address id    flat no    street name        city  ");
		for (Address address: sd) {
			
			System.out.println(address);
	}*/
		
		
		  // insert
				Employee em = new Employee();
				 
				 
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter employee id : ");
				 int id = sc.nextInt();
				 System.out.println("Enter employee first name");
				 String fname = sc.next();
				 System.out.println("Enter employee last name");
				 String lname = sc.next();
		          em.setEmp_id(id);
		         //ad.setEmp_id(10);
		         em.setEmp_first_name(fname);
		         em.setEmp_last_name(lname);;
		         
		         session.save(em);
		      
		         System.out.println("rows affected");
		         
		         
		         
		         
		       /*  Address ad = new Address();
		         ad.setAddress_id(6);
		         ad.setEmp_id(8);
		         ad.setFlat_no(45);
		         ad.setStreet_name("vevv");
		         ad.setCity("arab");
		         
		         
		         session.save(ad);
		        
		         t.commit();
		         session.close();
		         System.out.println("rows affected");*/

	}

}
