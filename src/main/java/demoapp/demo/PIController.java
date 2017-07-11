package demoapp.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class PIController {
	
	@GetMapping("/math/pi")
	public String getPi()
	{
		
		
		return "3.12343";
	}

}
