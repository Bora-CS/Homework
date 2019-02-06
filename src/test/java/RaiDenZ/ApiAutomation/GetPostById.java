package RaiDenZ.ApiAutomation;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPostById {
	 public static Response getPostById(String id) {
		 
		 System.out.println("*Test Case: Get post by id.");
	        
	        RestAssured.baseURI = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000";
	        
	        RequestSpecification request = RestAssured.given();
	        
	                
	        Response response = request.get("api/posts/?id:" + id);
	        
	        
	        
	        return response;
	    }
}
