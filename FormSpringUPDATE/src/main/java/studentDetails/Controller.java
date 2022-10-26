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


	@RequestMapping("/studentView")
	public ModelAndView studentView(HttpServletRequest request, HttpServletResponse res) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		List<User> users = session.createCriteria(User.class).list();
		mv.addObject("message", users);

		return mv;

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

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse res) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		int updateId = Integer.parseInt(request.getParameter("updateId"));
		Query q = session.createQuery("from User u where u.id =" + updateId);
		User user = (User) q.uniqueResult();
		int updateGetId = user.getId();
		String updateGetName = user.getName();

		ModelAndView mv = new ModelAndView();
		mv.addObject("updateGetId", updateGetId);
		mv.addObject("updateGetName", updateGetName);
		mv.setViewName("update.jsp");

		return mv;

	}

	@RequestMapping("/updateView")
	public ModelAndView updateView(HttpServletRequest request, HttpServletResponse res) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));

		Query q = session.createQuery("update User s set s.name = '" + name + "' where id=" + id);
		int result = q.executeUpdate();
		tx.commit();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		List<User> users = session.createCriteria(User.class).list();
		mv.addObject("message", users);

		return mv;
	}
}
