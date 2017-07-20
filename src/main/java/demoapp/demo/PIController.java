package demoapp.demo;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import demoapp.demo.passenger;
@RestController

public class PIController {
	
	private  int result;
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}


	@Autowired
	private MathService mathservice;

	@Autowired

	private Flight flighter;
	@Autowired

	private Flight flighterAnother;
	@Autowired

	private tickets tic;
	@Autowired

	private tickets ticAnother;



	@Autowired
	private passenger p;
	@Autowired
	private passenger pAnother;
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

	public String volume (@PathVariable("length") int length, @PathVariable("width") int width, @PathVariable("height") int height)
	{
		String result="The volume is"+(length*width*height);
		return result;

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

	// 4 th Unit JSOn Rendering
	@GetMapping("/flights/flight")
	public Flight renderJson()
	{


		p.setFirstName("chandana");
		p.setLastName("muppalla");


		tic.setPass(p);
		tic.setPrice(200);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date date;
		try {
			date = (Date)((DateFormat) formatter).parse("2017-04-21 14:31");

			String s = formatter.format(date);
			flighter.setDeparts(formatter.format(date) );
			formatter.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		ArrayList<tickets> tick= new ArrayList<tickets>();
		tick.add(tic);

		flighter.setTic(tick);
		return flighter;
	}


	@GetMapping("/flights")
	public ArrayList<Flight> renderJsonArray()
	{
		passenger p=new passenger();
		passenger pAnother=new passenger();
		Flight flighter=new Flight();
		Flight flighterAnother=new Flight();
		tickets  ticAnother=new tickets();
		ArrayList<Flight> flights=new ArrayList<Flight>();
		p.setFirstName("Some  name");
		p.setLastName("Some  other name");
		tic.setPass(p);
		tic.setPrice(200);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date date;
		try {
			date = (Date)((DateFormat) formatter).parse("2017-04-21 14:31");


			flighter.setDeparts(formatter.format(date) );
			formatter.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		ArrayList<tickets> tick= new ArrayList<tickets>();
		tick.add(tic);
		flighter.setTic(tick);
		flights.add(0,flighter);
		pAnother.setFirstName("Some other name");
		ticAnother.setPass(pAnother);
		ticAnother.setPrice(400);


		try {
			date = (Date)((DateFormat) formatter).parse("2017-04-21 14:31");


			flighterAnother.setDeparts(formatter.format(date) );
			formatter.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<tickets> ti= new ArrayList<tickets>();

		ti.add(ticAnother);

		flighterAnother.setTic(ti);
		flights.add(1,flighterAnother);
		return flights;
	}


	@PostMapping("/flights/tickets/total")
	public int Render(@RequestBody RequestObject  flights)
	{ 
		int sum=0;
		for(int i=0;i<flights.getTickets().size();i++)
		{
			sum=sum+flights.getTickets().get(i).getPrice();
			
		}
		System.out.println("HEYYYYYY "+flights.toString());
		result=sum;
		return result;
	}
}

