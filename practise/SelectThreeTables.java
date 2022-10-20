package practise;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Query;

public class SelectThreeTables {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		String hql = "from College";
		org.hibernate.query.Query query = session.createQuery(hql);

		List<College> sd = query.list();
		System.out.println("Data in college table");
		for (College student: sd) {
			
			System.out.print(student.getCollege_name());
			System.out.println("--"+student.getCollege_id());
	}
		
		
		
		String hql1 = "from Dept";
		org.hibernate.query.Query query1 = session.createQuery(hql1);

		List<Dept> d = query1.list();
		System.out.println("Data in dept table");
		for (Dept dept: d) {
			
			System.out.print(dept.getDept_name());
			System.out.println("--"+dept.getDept_id());
	}
		
		
		String hql2 = "from Professor";
		org.hibernate.query.Query query2 = session.createQuery(hql2);

		List<Professor> p = query2.list();
		System.out.println("Data in Professor table");
		for (Professor pp: p) {
			
			System.out.print(pp.getProfessor_name());
			System.out.println("--"+pp.getProfessor_id());
	}


}
}