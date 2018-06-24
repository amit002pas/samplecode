package App;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Value("${nameTest}")
	String name;
	
	@RequestMapping("/iae")
	public String checkTest(){
		System.out.println("name: "+name);
		return "working fine";
	}
	
	
}
