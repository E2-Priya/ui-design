package crudoperation.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	@RequestMapping("/test")
	public @ResponseBody ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("entered ------------");
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		List<User> users = session.createCriteria(User.class).list();

		ModelAndView model = new ModelAndView("hello");

		model.addObject("message", users);

		System.out.println("users object :" + users);
		return model;

	}

}
