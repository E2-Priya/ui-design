package MavenSample.SpringBootEx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {
	@RequestMapping("/SpringBoot")
	public  String hello() {
	
		System.out.println("Spring Boot Test");
		return " Welcome Spring ";
	}
          
}