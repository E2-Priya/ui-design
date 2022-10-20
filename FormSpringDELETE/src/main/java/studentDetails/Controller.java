package studentDetails;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

	public void session() {

	}

	@RequestMapping("/display")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse res) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));

		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("userclass.xml"); User student =
		 * context.getBean("stu", User.class);
		 */

		User student = new User();

		student.setName(name);

		student.setId(id);

		session.save(student);
		tx.commit();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		List<User> users = session.createCriteria(User.class).list();
		mv.addObject("message", users);

		return mv;

	}

	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse res) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		int deleteId = Integer.parseInt(request.getParameter("deleteId"));

		Query query = session.createQuery("delete from User where id =" + deleteId);
		int result = query.executeUpdate();
		tx.commit();

		System.out.println("rows affected" + result);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		List<User> users = session.createCriteria(User.class).list();
		mv.addObject("message", users);

		return mv;

	}

}
