import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
public class Res {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		

		Criteria cr = session.createCriteria(StudentDetails.class);
		
		
		// equals
		cr.add(Restrictions.eq("id", 13));
		  StudentDetails sd = (StudentDetails) cr.uniqueResult();
		/*List <StudentDetails>results = cr.list();
		for(StudentDetails sd : results) {*/
			System.out.println("Name of the student whose id is 13 is "+sd.getName());
		//}
		
		
		// greater than
		/*cr.add(Restrictions.gt("id",6 ));
		List <StudentDetails>r = cr.list();
		System.out.println("Name of the student whose id is greater than 6 ");
		for(StudentDetails sd : r) {
			System.out.println(sd.getName());
		}*/
		
		
		
		// is null
		/*cr.add(Restrictions.isNull("name"));
		List <StudentDetails>r = cr.list();
		System.out.println("Id of the student is empty : ");
		for(StudentDetails sd : r) {
			System.out.println(sd.getId());}*/
		
		
		//is empty-------error
		/*cr.add(Restrictions.isEmpty("name"));
		List <StudentDetails>r = cr.list();
		System.out.println("Id of the student is empty : ");
		for(StudentDetails sd : r) {
			System.out.println(sd.getId());}*/
		
		
		
		// or
		
		/*Criterion name = Restrictions.eq("name", "ishu");
		Criterion id = Restrictions.eq("id",13);

		
		LogicalExpression orExp = Restrictions.or(name, id);
		cr.add( orExp );
		List <StudentDetails>r = cr.list();
		
		for(StudentDetails sd : r) {
			System.out.println(sd.getId());
			System.out.println(sd.getName());}*/
		
		
		
		
		
		/*List<StudentDetails> results = cr.list();
		
		for(StudentDetails sd:results)
		{
		System.out.println(sd.getName());
		}*/
	}
}
