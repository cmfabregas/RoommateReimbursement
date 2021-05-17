package com.example.roommatereimbursement;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.example.model.User;

import junit.framework.Assert;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class RoommateReimbursementApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:4200" +"/",
				String.class)).contains("app-root");
	}
	@Test
	public void Login() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:4200/login" +"/",
				String.class)).contains("login");
	}
	
	  @Test
	    public void testloginbackend() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:9010/login/login";
	        URI uri = new URI(baseUrl);
	        User employee = new User(null, "sam", "777", "test@email.com");
	         
	        HttpHeaders headers = new HttpHeaders();
	 
	        HttpEntity<User> request = new HttpEntity<>(employee, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        //Verify bad request and missing header
	        Assert.assertEquals(200, result.getStatusCodeValue());
	      //  Assert.assertEquals(true, result.getBody().contains("Missing request header"));
	    }
	  
	  
	  
	  
	  
	  
}
