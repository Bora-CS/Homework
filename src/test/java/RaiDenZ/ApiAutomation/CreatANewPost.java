package RaiDenZ.ApiAutomation;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreatANewPost {
	public static Response creatANewPost(String token, Object textToPut) {
		
		System.out.println("*Test Case: Create a new post.");
        
		RestAssured.baseURI = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000";
		        
		        RequestSpecification request = RestAssured.given();
		        
		        request.header("Authorization", token);
		        
		        request.header("Content-Type", "application/json");
		        
		        JSONObject requestBody = new JSONObject();
		        
		        requestBody.put("text", textToPut);
		        
		        request.body(requestBody);
		        
		        Response response = request.post("/api/posts");
		        
		        
		        return response;
		    }
	
	
	public static String idInNewPostToDelete() {
		
		RestAssured.baseURI = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000";
        
        RequestSpecification request = RestAssured.given();
        
        request.header("Authorization", DataProvider.token );
        
        request.header("Content-Type", "application/json");
        
        JSONObject requestBody = new JSONObject();
        
        requestBody.put("text", "This is just a sample to check delete function.");
        
        request.body(requestBody);
        
        Response response = request.post("/api/posts");
        
        JsonPath jP = response.jsonPath();
        
        HashMap<String, String> post = jP.get("");
        
        String id = post.get("_id");
        
        return id;
	}
	
}



