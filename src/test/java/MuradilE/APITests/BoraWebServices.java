package MuradilE.APITests;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BoraWebServices {

	public static final String APPLICATION_URL = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000/api";

	public static void main(String[] args) {
		String email = "jam1993625@gmail.com";
		String password = "123456";
		String token = logInTest(email, password);
		String actualEmail = getCurrentUserTest(token);
		System.out.println("-----------------------------------");
		Assert.assertEquals(email, actualEmail, "The output data doesn't match the input data");	
	}

	public static String getCurrentUserTest(String token) {	
		System.out.println("-----------------------------------");
		System.out.println("Getting the current logged in user:");
		RestAssured.baseURI = APPLICATION_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", token);
		Response response = request.get("/users/current");
		String responseString = response.getBody().asString();
		Assert.assertEquals(response.getStatusCode(), 200, "The status code is not expected");
		System.out.println("Response Body:\t" + responseString);
		String email = responseString.split(":")[3].replaceAll("\"", "").replace("}", "");
		return email;
	}

	public static String logInTest(String email, String password) {
		System.out.println("-----------------------------------");
		System.out.println("Logging in for: "+ email);
		// Log in
		// Define our URI for the web service
		RestAssured.baseURI = APPLICATION_URL;
		// Create a request object
		RequestSpecification request = RestAssured.given();
		// Adding header values
		request.header("Content-Type", "application/json");
		// First create a JSON object
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", email);
		requestBody.put("password", password);
		// Attach the JSON object as part the request body
		request.body(requestBody);
		// Post the request, and get the response
		Response response = request.post("/users/login");
		// Retrieving the status code
		int statusCode = response.getStatusCode();
		// Assert on the status code
		Assert.assertEquals(statusCode, 200, "The status code is not expected.");
		// Retrieving the response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:\t" + responseBody);
		int startingIndex = responseBody.indexOf("Bearer");
//		System.out.println(responseBody.substring(startingIndex, responseBody.length() - 2));
		String token = responseBody.substring(startingIndex, responseBody.length() - 2);
//		System.out.println(responseBody.split(":")[2].replaceAll("\"", "").replace("}", ""));
		// Assert on the response body
		Assert.assertTrue(responseBody.contains("token"), "The token is not found in the response body");
		return token;
	}

}
