package demoapp.demo;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
@Service
public class MathService {
	
	public int mathCalculate(String operation,int x,int y)
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

	public int mathSum(WebRequest webRequest)
	{
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
