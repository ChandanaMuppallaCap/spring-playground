package demoapp.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(PIController.class)
public class PIControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testIndexEndpoint() throws Exception {
		this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		.andExpect(content().string("3.12343"));
	}
	@Test
	public void testaddEndpoint() throws Exception {
		this.mvc.perform(get("/math/calculate?operation={op}&x={op1}&y={op2}", "add",1,2)).
		andExpect(status().isOk())
		.andExpect(content().string("3"));
	}

	@Test
	public void testsubtractEndpoint() throws Exception {
		this.mvc.perform(get("/math/calculate?operation={op}&x={op1}&y={op2}", "subtract",1,2)).
		andExpect(status().isOk())
		.andExpect(content().string("-1"));
	}

	@Test
	public void testdivideEndpoint() throws Exception {
		this.mvc.perform(get("/math/calculate?operation={op}&x={op1}&y={op2}", "divide",1,2)).
		andExpect(status().isOk())
		.andExpect(content().string("0"));
	}

	@Test
	public void testmultiplyEndpoint() throws Exception {
		this.mvc.perform(get("/math/calculate?operation={op}&x={op1}&y={op2}", "multiply",1,2)).
		andExpect(status().isOk())
		.andExpect(content().string("2"));
	}

	@Test
	public void testdefaultEndpoint() throws Exception {
		this.mvc.perform(get("/math/calculate?operation={op}&x={op1}&y={op2}","noop",1,2)).
		andExpect(status().isOk())
		.andExpect(content().string("3"));
	}
	@Test
	public void testSumEndpoint() throws Exception {
		this.mvc.
		perform(post("/math/sum?n={var1}&n={var2}&n={var3}", 2, 4, 2)).andExpect(status().isOk())
		.andExpect(content().string("8"));}	

	@Test

	public void testPostVolumeEndpoint() throws Exception {
		this.mvc.
		perform(post("/math/volume/{var1}/{var2}/{var3}", 2, 4, 2)).andExpect(status().isOk())
		.andExpect(content().string("The volume is16"));}	
	@Test	 
	public void testGetVolumeEndpoint() throws Exception {
		this.mvc.
		perform(get("/math/volume/{var1}/{var2}/{var3}", 2, 4, 2)).andExpect(status().isOk())
		.andExpect(content().string("The volume is16"));}	

	@Test
	public void testPatchVolumeEndpoint() throws Exception {
		this.mvc.
		perform(patch("/math/volume/{var1}/{var2}/{var3}", 2, 4, 2)).andExpect(status().isOk())
		.andExpect(content().string("The volume is16"));}	

	@Test
	public void testAreaEndpoint() throws Exception {


		MockHttpServletRequestBuilder request = post("/math/area")

				.param("type", "circle")
				.param("radius", "3");

		System.out.println("In Area test");


		this.mvc.
		perform(request).andExpect(status().isOk())
		.andExpect(content().string("Area of circlewith radius 3.0is 28.259999999999998"));

	}	

	@Test
	public void testAreaRectangleEndpoint() throws Exception {


		MockHttpServletRequestBuilder request = post("/math/area")

				.param("type", "rectangle")
				.param("length", "3")
				.param("width", "3");


		System.out.println("In Area test");
		this.mvc.
		perform(request).andExpect(status().isOk())
		.andExpect(content().string("Area of rectangle with width 3.0 and length 3.0is 9.0"));

	}	

	@Test
	public void testErrorpoint() throws Exception {


		MockHttpServletRequestBuilder request = post("/math/area")

				.param("type", "circle")
				.param("width", "3");


		System.out.println("In Area test");


		this.mvc.
		perform(request).andExpect(status().isOk())
		.andExpect(content().string("Invalid"));

	}	
	@Test
	public void testErrorpoint2() throws Exception {


		MockHttpServletRequestBuilder request = post("/math/area")

				.param("type", "circle")
				.param("length", "3");


		System.out.println("In Area test");


		this.mvc.
		perform(request).andExpect(status().isOk())
		.andExpect(content().string("Invalid"));

	}	

	@Test
	public void testErrorpoint3() throws Exception {


		MockHttpServletRequestBuilder request = post("/math/area")

				.param("type", "rectangle")
				.param("radius", "3");


		System.out.println("In Area test");


		this.mvc.
		perform(request).andExpect(status().isOk())
		.andExpect(content().string("Invalid"));

	}	

	@Test
	public void testJsonString() throws Exception {
		this.mvc.perform(
				post("/flights/tickets/total")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\"tickets\": [{\"passenger\": {\"firstName\": \"Chandana\", \"lastName\":\"M\"}, \"price\": 300},{\"passenger\": {\"firstName\": \"Chandra\", \"lastName\":\"G\"}, \"price\": 150}]}"))


		.andExpect(status().isOk());




	}

	@Test
	public void testObject() throws Exception {


		tickets t=new tickets();
		tickets t1=new tickets();
		ArrayList<tickets> tic=new ArrayList();
		passenger p=new passenger();
		p.setFirstName("chandana");
		p.setLastName("muppalla");
		passenger p2=new passenger();
		p2.setFirstName("angelica");
		p2.setLastName("schuyler");
		t.setPass(p);
		t1.setPass(p2);
		t1.setPrice(50);
		t.setPrice(300);
		tic.add(t);
		tic.add(t1);





		RequestObject r=new RequestObject();

		r.setTickets(tic);







		ObjectMapper json=new ObjectMapper();
		String json1 = json.writeValueAsString(r); 

		System.out.println("VALUE"+json1);

		MockHttpServletRequestBuilder request = post("/flights/tickets/total")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json1);                                         // 4

		this.mvc.perform(request).andExpect(status().isOk());

	}

	@Test
	public void testingBody() throws Exception {
		String json = getJSON("src/test/resources/data.json");
		System.out.println(json);
		MockHttpServletRequestBuilder request = post("/flights/tickets/total")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);

		this.mvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().string("350"));
		
	}

	private String getJSON(String path) throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
	System.out.println("PATH"+path);
		//File file = new File(classLoader.getResource(path).getFile());
		/*System.out.println("Path"+path);
		URL url = this.getClass().getResource(path);
		System.out.println("URL"+url);
		
*/		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
