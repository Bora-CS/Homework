package MuradilE.APITests;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BoraWebServices_2 extends BoraWebServices{
	
	
	public static void getAllUserProfiles () {
		
		System.out.println("-----------------------------------");
		RestAssured.baseURI = APPLICATION_URL;
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/profile/all");
		String responseString = response.getBody().asString();
		System.out.println(responseString);
		
		JsonPath jsonPath = response.jsonPath();
		
		ArrayList<String> skills = jsonPath.get("[0].skills");
		System.out.println(skills);
		
		HashMap<String, String> social = jsonPath.get("[0].social");
		System.out.println(social);
		
		String linkedIn = jsonPath.get("[0].social.linkedin");
		System.out.println(linkedIn);
	}
	
}
