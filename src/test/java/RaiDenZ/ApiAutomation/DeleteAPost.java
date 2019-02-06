package RaiDenZ.ApiAutomation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteAPost {

	public static Response deleteAPost(String id, String token) {
		
		System.out.println("*Test case: Delete a post.");
        
	    RestAssured.baseURI = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000";
	        
	        RequestSpecification request = RestAssured.given();
	        
	        request.header("Authorization", token);
	        
	        Response response = request.delete("api/posts/" + id);
	        
	        
	        return response;
	        
	    }
	
}
