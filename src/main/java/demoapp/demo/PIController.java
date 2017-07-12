package demoapp.demo;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
@RestController

public class PIController {
	@Autowired
	private MathService mathservice;

	@GetMapping("/math/pi")
	public String getPi()
	{
		return "3.12343";
	}

	@GetMapping("/math/calculate")

	public int getMath(@RequestParam(value = "operation", defaultValue = "noop") String operation, @RequestParam("x")int x , @RequestParam("y")int  y)
	{
	return	mathservice.mathCalculate(operation,x,y);
	}

	@PostMapping("/math/sum")
	public int getAll(WebRequest webRequest){
		return mathservice.mathSum(webRequest);
	}




}
