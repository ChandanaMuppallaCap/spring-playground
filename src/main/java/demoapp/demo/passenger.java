package demoapp.demo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonRootName;
@Component

public class passenger {
	
	
		 private  String firstName;
		 private String lastName;
		 
		 public void setFirstName( String firstName)
		 {
			 this.firstName=firstName;
		 }
		 
		 public void setLastName(String lastName)
		 {
			 this.lastName=lastName;
		 }

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
		 

}
