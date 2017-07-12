package demoapp.demo;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/math/volume/{length}/{width}/{height}")

	public int volume (@PathVariable("length") int length, @PathVariable("width") int width, @PathVariable("height") int height)
	{

		return length*width*height;

	}

	@PostMapping("/math/area")
	public String Area(@RequestParam Map<String, String> params){
		String type=params.get("type");


		double area=0.0;
		String result="";

		if(type.equalsIgnoreCase("circle"))
		{
			if(params.containsKey("width")|| params.containsKey("length"))
			{
				result ="Invalid";
			}
			else{
				Double radius=Double.parseDouble(params.get("radius"));
				area=3.14*radius*radius;
				result="Area of "+type  +"with radius "+ radius +"is "+ area;
			}
		}

		else if (type.equalsIgnoreCase("rectangle"))
		{

			if(params.containsKey("radius"))
			{
				result="Invalid";
			}
			else{
				Double width=Double.parseDouble(params.get("width"));
				Double length=Double.parseDouble(params.get("length"));
				area=length*width;
				result="Area of "+type  +" with width "+width +" and length " + length +"is "+ area;
			}
		}

		return result;
	}


}

