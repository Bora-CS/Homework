package MuzappaeEApi;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddExperienceTest {

	public static String Application_URl = "http://ec2-54-243-3-145.compute-1.amazonaws.com:5000/api";

	public static void main(String[] args) {
		String email = "Muzappar.erkin0122@gmail.com";
		String password = "123456";
		String token = loginTest(email, password);
		System.out.println(token);
		creatUserprofile(token);
		addExperienceProfile(token);
		deleteExperienceProfile(token);

	}

	public static String loginTest(String email, String password) {
		System.out.println("Logging in for :" + email);
		RestAssured.baseURI = Application_URl;
		RequestSpecification requst = RestAssured.given();
		requst.header("Content-Type", "application/json");
		JSONObject requstBody = new JSONObject();
		requstBody.put("email", "Muzappar.erkin0122@gmail.com");
		requstBody.put("password", "123456");
		requst.body(requstBody);
		Response response = requst.post("/users/login");
		int statusCode = response.getStatusCode();
		System.out.println("Response Status Code:\t" + statusCode);
		Assert.assertEquals(statusCode, 200, "The status code is not expected" + statusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:\t" + responseBody + "\n");
		int startingIndex = responseBody.indexOf("Bearer");
		String token = responseBody.substring(startingIndex, responseBody.length() - 2);
		Assert.assertTrue(responseBody.contains("token"), "The token is not found in the responde");
		return token;

	}

	public static void creatUserprofile(String token) {
		RestAssured.baseURI = Application_URl;
		RequestSpecification requst = RestAssured.given();
		requst.header("Content-Type", "application/json");
		requst.header("Authorization", token);
		JSONObject requstBody = new JSONObject();
		requstBody.put("handle", "Muzappar");
		requstBody.put("company", "Bora Tech");
		requstBody.put("website", "https://www.bora-cs.com/");
		requstBody.put("location", "Fairfax, VA");
		requstBody.put("status", "Developer");
		requstBody.put("skills", "HTML, CSS, JavaScript");
		requstBody.put("bio", "I'm best test automation engineer among developers :)");
		requstBody.put("githubusername", "SlowGti");
		requst.body(requstBody);
		Response response = requst.post("/profile");
		int statusCode = response.getStatusCode();
		System.out.println("Response Status Code:\t" + statusCode);
		Assert.assertEquals(statusCode, 200, "The status code is not expected" + statusCode);
		String responseString = response.getBody().asString();
		Assert.assertEquals(response.getStatusCode(), 200, "The status code is expected");
		System.out.println("Response Body:\t" + responseString + "\n");
	}

	public static void addExperienceProfile(String token) {
		RestAssured.baseURI = Application_URl;
		RequestSpecification requst = RestAssured.given();
		requst.header("Content-Type", "application/json");
		requst.header("Authorization", token);
		JSONObject requstBody = new JSONObject();
		ArrayList<HashMap<String, String>> testData = testAddExpericenceProfileData();
		for (int i = 0; i < testData.size(); i++) {
			HashMap<String, String> td = testData.get(i);
			System.out.println("Test Running Iteration - " + (i + 1));
			requstBody.put("title", td.get("title"));
			requstBody.put("company", td.get("company"));
			requstBody.put("location", td.get("location"));
			requstBody.put("from", td.get("from"));
			requstBody.put("to", td.get("to"));
			requstBody.put("description", td.get("description"));
			System.out.println("The expected stutas code is -" + td.get("expectedStatusCode"));
			requst.body(requstBody);
			Response response = requst.post("/profile/experience");
			int statusCode = response.getStatusCode();
			System.out.println("Response Status Code:\t" + statusCode);
			if (statusCode != 200 || statusCode != 400) {
				System.out.println("The status code is expected");
			}

			String responseString = response.getBody().asString();

			System.out.println("Response Body:\t" + responseString + "\n");
		}

	}

	public static void deleteExperienceProfile(String token) {
		RestAssured.baseURI = Application_URl;
		RequestSpecification requst = RestAssured.given();
		requst.header("Content-Type", "application/json");
		requst.header("Authorization", token);
		JSONObject requstBody = new JSONObject();
		ArrayList<HashMap<String, String>> testData = deleteExpericenceProfileData();
		for (int i = 0; i < testData.size(); i++) {
			HashMap<String, String> td = testData.get(i);
			System.out.println("Test Running Iteration - " + (i + 1));
			System.out.println("The expected stutas code is -" + td.get("expectedStatusCode"));
			requst.body(requstBody);
			Response response = requst.delete("/profile/experience/" + td.get("_id"));
			int statusCode = response.getStatusCode();
			System.out.println("Response Status Code:\t" + statusCode);
			if (statusCode != 200 || statusCode != 400) {
				System.out.println("The status code is expected");
			}

			String responseString = response.getBody().asString();
			System.out.println("Response Body:\t" + responseString + "\n");
		}
	}

	public static ArrayList<HashMap<String, String>> testAddExpericenceProfileData() {

		HashMap<String, String> test1 = new HashMap<String, String>();
		test1.put("title", "Automation Enginner111");
		test1.put("company", "Google");
		test1.put("location", "Fairfax,Va");
		test1.put("from", "2018-01-01");
		test1.put("to", "2020-01-01");
		test1.put("description", "Nice place to work at");
		test1.put("expectedStatusCode", "200");

		HashMap<String, String> test2 = new HashMap<String, String>();
		test2.put("title", "");
		test2.put("company", "Google");
		test2.put("location", "Fairfax,Va");
		test2.put("from", "2018-01-01");
		test2.put("to", "2020-01-01");
		test2.put("description", "Nice place to work at");
		test2.put("expectedStatusCode", "400");

		HashMap<String, String> test3 = new HashMap<String, String>();
		test3.put("title", "Automation Enginner111");
		test3.put("company", "");
		test3.put("location", "Fairfax,Va");
		test3.put("from", "2018-01-01");
		test3.put("to", "2020-01-01");
		test3.put("description", "Nice place to work at");
		test3.put("expectedStatusCode", "400");

		HashMap<String, String> test4 = new HashMap<String, String>();
		test4.put("title", "");
		test4.put("company", "");
		test4.put("location", "");
		test4.put("from", "2018-01-01");
		test4.put("to", "2020-01-01");
		test4.put("description", "Nice place to work at");
		test4.put("expectedStatusCode", "400");

		ArrayList<HashMap<String, String>> addExpData = new ArrayList<>();
		addExpData.add(test1);
		addExpData.add(test2);
		addExpData.add(test3);
		addExpData.add(test4);
		return addExpData;
	}

	public static ArrayList<HashMap<String, String>> deleteExpericenceProfileData() {

		HashMap<String, String> test1 = new HashMap<String, String>();
		test1.put("current", "false");
		test1.put("_id", "5c55cda13342c205c707b43");
		test1.put("title", "Senior Automation Enginner");
		test1.put("company", "Capital One");
		test1.put("location", "McLean, VA");
		test1.put("from", "2017-09-15T00:00:00.000Z");
		test1.put("to", "2018-06-30T00:00:00.000Z");
		test1.put("description", "Nice place to work at");
		test1.put("expectedStatusCode", "200");

		HashMap<String, String> test2 = new HashMap<String, String>();
		test2.put("current", "false");
		test2.put("_id", "5c5394e");
		test2.put("title", "Senior Automation Enginner");
		test2.put("company", "Capital One");
		test2.put("location", "McLean, VA");
		test2.put("from", "2017-09-15T00:00:00.000Z");
		test2.put("to", "2018-06-30T00:00:00.000Z");
		test2.put("description", "Nice place to work at");
		test2.put("expectedStatusCode", "400");

		ArrayList<HashMap<String, String>> deleteExperienceTestData = new ArrayList<HashMap<String, String>>();
		deleteExperienceTestData.add(test1);
		deleteExperienceTestData.add(test2);

		return deleteExperienceTestData;

	}

}
