package RaiDenZ.ApiAutomation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllPosts {

	public static Response getAllPosts() {
		
		System.out.println("*Test Case: Get all posts.");
		
        RestAssured.baseURI = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000";
        
        RequestSpecification request = RestAssured.given();
        
        Response response = request.get("/api/posts");
        
        
        
        return response;
    }
    
  
    

	
}
