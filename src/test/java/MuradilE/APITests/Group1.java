package MuradilE.APITests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Group1 {
	
	public static final String APPLICATION_URL = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000/";

	public String login() {
		RestAssured.baseURI = APPLICATION_URL;
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "Application/json");
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", "miller.muradil@gmail.com");
		requestBody.put("password", "murad001");
		request.body(requestBody);
		
		Response response = request.post("api/users/login");
		Assert.assertEquals(response.getStatusCode(), 200, "The login request is not successful");
		
		JsonPath jp = response.jsonPath();
		String token = jp.get("token");		
		return token;	
	}
	
	@Test
	public void test() {
		String token = login();
		System.out.println("Token ==> " + token);
		
		ArrayList<Experience> data = ExperienceTestData.getData();
		ArrayList<HashMap<String, String>> results = ExperienceTestData.getExpectedResult();
			
		for (int i = 0; i < data.size(); i++) {
			System.out.println("-------------------------------------------");
			System.out.println("Test Run - " + (i+1));
			System.out.println("Expected Status - " + results.get(i).get("StatusCode"));
			addExperience(token, data.get(i), results.get(i));	
			System.out.println();

		} 
	}
	
	
	public void addExperience (String token, Experience data, HashMap<String, String> expectedResults) {
		
		RestAssured.baseURI = APPLICATION_URL;
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "Application/json");
		request.header("Authorization", token);
		
		JSONObject requestBody = new JSONObject();
		System.out.println("Request Data:");
		System.out.println("title:\t" + data.title);
		System.out.println("company:\t" + data.company);
		System.out.println("location:\t" + data.location);
		System.out.println("from:\t" + data.from);
		System.out.println("to:\t" + data.to);
		System.out.println("description:\t" + data.description);
		
		requestBody.put("title", data.title);
		requestBody.put("company", data.company);
		requestBody.put("location", data.location);
		requestBody.put("from", data.from);
		requestBody.put("to", data.to);
		requestBody.put("description", data.description);			
		request.body(requestBody);
		
		String statusCode = expectedResults.get("StatusCode");
		
		Response response = request.post("api/profile/experience");
		System.out.println("Response Body - " + response.getBody().asString());
		Assert.assertEquals(response.getStatusCode()+"", statusCode);
		
		JsonPath jp = response.jsonPath();
		if (statusCode.equals("200")) {
			Experience[] experiences = jp.getObject("experience", Experience[].class);
			
			boolean found = false;
			for (Experience experience : experiences) {
				if (experience.title.equals(expectedResults.get("title")) && experience.company.equals(expectedResults.get("company"))) {
					experience.from = experience.from.split("T")[0];
					experience.to = experience.to.split("T")[0];
					Assert.assertEquals(expectedResults.get("location"), experience.location, "Location does not match");
					Assert.assertEquals(expectedResults.get("from"), experience.from, "From date does not match");
					Assert.assertEquals(expectedResults.get("to"), experience.to, "To date does not match");
					Assert.assertEquals(expectedResults.get("description"), experience.description, "Description does not match");
					found = true;
				}	
			}
			
			Assert.assertTrue(found,"The experience is not found");
		} else {
			Map<String, String> actualResult = jp.get("");
			
			for ( String key : actualResult.keySet()) {
				Assert.assertEquals(actualResult.get(key), expectedResults.get(key));
			}
		}
	}
}
