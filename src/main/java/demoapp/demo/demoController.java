package demoapp.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class demoController {
	@RequestMapping("/")
public String	getValue()
	{
		return "HelloSpring";
	}

}

