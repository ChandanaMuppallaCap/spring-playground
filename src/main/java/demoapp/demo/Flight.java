package demoapp.demo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Flight")
@Component
public class Flight implements Serializable{
	
	@JsonFormat( pattern= "yyyy-MM-dd")
 private String departs;
	
	

 private ArrayList<tickets> tic;
 



public String getDeparts() {
	return departs;
}

public void setDeparts(String departs) {
	this.departs = departs;
}
@JsonProperty("tickets")
public ArrayList<tickets> getTic() {
	return tic;
}
public void setTic(ArrayList<tickets> tic) {
	this.tic = tic;
}

 

	


}
