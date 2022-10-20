package addPackage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse res) {
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		int k = i + j;
		System.out.println(i);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addDisplay.jsp");
		mv.addObject("result", k);
		return mv;
	}

	@RequestMapping("/sub")
	public ModelAndView sub(HttpServletRequest request, HttpServletResponse res) {
		int ii = Integer.parseInt(request.getParameter("num1"));
		int jj = Integer.parseInt(request.getParameter("num2"));
		int kk = ii-jj;
		System.out.println(ii);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addDisplay.jsp");
		mv.addObject("result", kk);
		return mv;
	}
	
	@RequestMapping("/mul")
	public ModelAndView mul(HttpServletRequest request, HttpServletResponse res) {
		int ii = Integer.parseInt(request.getParameter("num1"));
		int jj = Integer.parseInt(request.getParameter("num2"));
		int kk = ii*jj;
		System.out.println(ii);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addDisplay.jsp");
		mv.addObject("result", kk);
		return mv;
	}
	
	@RequestMapping("/divi")
	public ModelAndView divi(HttpServletRequest request, HttpServletResponse res) {
		int ii = Integer.parseInt(request.getParameter("num1"));
		int jj = Integer.parseInt(request.getParameter("num2"));
		int kk = ii/jj;
		System.out.println(ii);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addDisplay.jsp");
		mv.addObject("result", kk);
		return mv;
	}
}
