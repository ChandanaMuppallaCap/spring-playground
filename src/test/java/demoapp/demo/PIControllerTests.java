package demoapp.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
	
	 public void testSumEndpoint() throws Exception {
		    this.mvc.
			perform(post("/math/sum?n={var1}&n={var2}&n={var3}", 2.0, 4.0, 2.0)).andExpect(status().isOk())
	                .andExpect(content().string("8"));}	

	



}
