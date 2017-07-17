package demoapp.demo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class tickets {
	
private passenger pass;

private int price ;
@JsonProperty("passenger")
public passenger getPass() {
	return pass;
}

public void setPass(passenger pass) {
	this.pass = pass;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

}
