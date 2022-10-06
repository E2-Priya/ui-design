package HelloPackage;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/test")
	public @ResponseBody String display() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(5);
		System.out.println("test--------");
		return "test";
	}
}