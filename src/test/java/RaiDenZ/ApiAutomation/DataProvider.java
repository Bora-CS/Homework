package RaiDenZ.ApiAutomation;



import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataProvider {

	public static final String email = "jam1993625@gmail.com";
	
	public static final String password = "123456";
	
	public static final String token = login();
	
	public static final String postId = "5c55c4693342c205c707b414";
	
	public static final String postIdFromOthers = "5c53a4723342c205c707b406";
	
	
	
	public static HashMap MapDataForNewPost() {
		HashMap<String, String> newPostData = new HashMap<String, String>();
		
		newPostData.put("valid data", "You are the everything I need.");
		//10 chars
		newPostData.put("10 chars", "1234567890");
		//300 chars
		newPostData.put("300 chars", StringUtils.repeat('q', 300));
		//empty text
		newPostData.put("empty text", "");
		//less than 10
		newPostData.put("less than 10 chars", "123456789");
		//more than 300
		newPostData.put("more than 300 chars", StringUtils.repeat('q', 301));

	
		return newPostData;
		
		
	}
	
	
	
	  
	 
	
	public static String login(){
		
	
		
		RestAssured.baseURI = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000";
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", email);
		requestBody.put("password", password);
		
		request.body(requestBody);
	
		Response response = request.post("/api/users/login");
		
		JsonPath jP = response.jsonPath();
		
		HashMap<String, String> loginBody = jP.get("");
		
		String token = loginBody.get("token");
		
		return token;
		
	}
	

	
	
}
