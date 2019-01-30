package MuradilE.APITests;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BoraWebServices {

	public static final String APPLICATION_URL = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000/api";

	public static void main(String[] args) {
		
		// Log in 
		// Define our URI for the web service
		RestAssured.baseURI = APPLICATION_URL;
		
		// Create a request object
		RequestSpecification request = RestAssured.given();
		
		// Adding header values 
		request.header("Content-Type", "application/json");
		
		// First create a JSON object
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", "miller.muradil@gmail.com");
		requestBody.put("password", "murad001");
		
		// Attach the JSON object as part the request body
		request.body(requestBody);
		
		// Post the request, and get the response
		Response response = request.post("/users/login");
		
		// Retrieving the status code
		int statusCode = response.getStatusCode();
		System.out.println("Response Status Code:\t" + statusCode);
		
		// Retrieving the response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:\t" + responseBody);

	}

}
