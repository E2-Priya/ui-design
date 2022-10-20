package onetomany;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetomanyFetch {
public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		String hql = "from Department";
		Query query = session.createQuery(hql);
		
		System.out.println("hello");

		List<Department> sd = query.list();
		
		for (Department address: sd) {
			
			System.out.println(address.getDeptId());
		
		}
}}
