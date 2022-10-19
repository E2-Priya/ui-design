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
	public @ResponseBody ModelAndView home(HttpServletRequest request,
		      HttpServletResponse response) throws Exception {
		System.out.println("entered ------------");
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
	            .buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<User> users = session.createCriteria(User.class).list();
		
		
		List<User> u = new ArrayList<User>();
	
		u.addAll(users);
		System.out.println("u  ;:"+u);
		
		
		 Iterator<User> it = users.iterator();
		 ModelAndView model = new ModelAndView("hello");
		 while(it.hasNext()) {
			  System.out.println(it.next());
			}
	

	        // Using  for loop for iteration 
	        for (int i = 0; i < u.size(); i++) { 
	  
	            // Using get() method to 
	            // access particular element 
	            System.out.print(u.get(i) + " "); 
	        } 
		 
		 
		 
	      model.addObject("message", u);
	      System.out.println("it oblect :"+it);
	      System.out.println("users oblect :" +users);
	      return model;

	}

}
