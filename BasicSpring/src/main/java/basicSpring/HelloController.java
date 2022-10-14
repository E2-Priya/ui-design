package basicSpring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{
	 @Override
	   protected ModelAndView handleRequestInternal(HttpServletRequest request,
	      HttpServletResponse response) throws Exception {
		 System.out.println("inside controller");
	      
	      ModelAndView model = new ModelAndView("hello");
	      model.addObject("message", "E2");
	      System.out.println("ended");
	      return model;
	      
	   }

}
