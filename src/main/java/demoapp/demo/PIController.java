package demoapp.demo;

import java.util.Map;

import org.springframework.util.MultiValueMap;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
@RestController

public class PIController {

	@GetMapping("/math/pi")
	public String getPi()
	{


		return "3.12343";
	}


	@GetMapping("/math/calculate")

	public int getMath(@RequestParam(value = "operation", defaultValue = "noop") String operation, @RequestParam("x")int x , @RequestParam("y")int  y)
	{
		int z=0;

		if(operation.equalsIgnoreCase("add"))
		{
			z=x+y;


		}
		else if(operation.equalsIgnoreCase("subtract"))
		{
			z=x-y;
		}
		else if(operation.equalsIgnoreCase("multiply"))
		{
			z= x*y;
		}
		else if(operation.equalsIgnoreCase("divide"))
		{
			z= x/y;
		}
		else
		{
			z=x+y;
		}

		return z;
	}

	@PostMapping("/math/sum")
	public int getAll(WebRequest webRequest){
		Map<String, String[]> params = webRequest.getParameterMap();

		String [] values = params.get( "n" );//Key value
		int z=0;
		int size=values.length;
		

		while( size!=0)
		{ 
		

			z= z+Integer.parseInt(values[size-1].toString());

			size=size-1;

		}

		return z;
	}




}
