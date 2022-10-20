import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

import antlr.collections.*;
import java.util.List;

public class Pro {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		

	// retrive name column
	/*	Criteria c = session.createCriteria(StudentDetails.class);
        PropertyProjection p = Projections.property("name");
        List<String> students = c.setProjection(p).list();
        for(String s:students)
            System.out.println(s);
       */
		
		// row count
		 /*Criteria c = session.createCriteria(StudentDetails.class);
		 c.setProjection(Projections.rowCount());
		 List rowCount = c.list();

         System.out.println("Total Count: " + rowCount.get(0) );*/
		
		
		
		// max value in the column
	/*	Criteria c = session.createCriteria(StudentDetails.class);
		 c.setProjection(Projections.max("id"));
		 List rowCount = c.list();

        System.out.println("Max: " + rowCount.get(0) );*/
		
		
	// desc order
		Criteria c = session.createCriteria(StudentDetails.class);
		c.addOrder(Order.desc("id"));
		List <StudentDetails> sd = c.list();
		for(StudentDetails s:sd)
			System.out.println(s.getId());
		
        

}
}
