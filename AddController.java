package addPackage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/add")  
	public ModelAndView add(HttpServletRequest request, HttpServletResponse res)  
    {  
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		int k= i+j;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addDisplay.jsp");
		mv.addObject("result", k);
       return mv;  
    }    
}
