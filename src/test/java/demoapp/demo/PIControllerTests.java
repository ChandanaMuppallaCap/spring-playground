package demoapp.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
	    
	   /* @Autowired
		private WebApplicationContext ctx;

		@Before
		public void setUp() {
			this.mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		}*/

	    @Test
	    public void testIndexEndpoint() throws Exception {
	        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
	                .andExpect(status().isOk())
	                .andExpect(content().string("3.12343"));
	    }

}
