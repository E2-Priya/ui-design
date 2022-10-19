package studentDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
	@RequestMapping("/display")  
	public ModelAndView add(HttpServletRequest request, HttpServletResponse res)  
    {  
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		int className = Integer.parseInt(request.getParameter("class"));
		String address = request.getParameter("address");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("name", name);
		mv.addObject("id", id);
		mv.addObject("className", className);
		mv.addObject("address", address);
       return mv;  
    }    
}
