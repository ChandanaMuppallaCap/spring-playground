package demoapp.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	                .andExpect(content().string("16"));}	
	@Test	 
	 public void testGetVolumeEndpoint() throws Exception {
		    this.mvc.
			perform(get("/math/volume/{var1}/{var2}/{var3}", 2, 4, 2)).andExpect(status().isOk())
	                .andExpect(content().string("16"));}	

	@Test
	 public void testPatchVolumeEndpoint() throws Exception {
		    this.mvc.
			perform(patch("/math/volume/{var1}/{var2}/{var3}", 2, 4, 2)).andExpect(status().isOk())
	                .andExpect(content().string("16"));}	

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


	

}
