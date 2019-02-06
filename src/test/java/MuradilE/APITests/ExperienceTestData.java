package MuradilE.APITests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExperienceTestData {
	
	private static String title = "Manual Tester - 1";
	private static String company = "Facebook";
	private static String location = "San francisco";
	private static String from = "1993-09-15";
	private static String to = "1997-06-30";
	private static String description = "Really stressful, not enough salary, not happy at all";
	
	public static ArrayList<Experience> getData () {
		
		ArrayList<Experience> exps = new ArrayList<>();
		Experience exp1 = new Experience(title, company, location, from, to, description);
		Experience exp2 = new Experience("", company, location, from, to, description);
		Experience exp3 = new Experience(title, "", location, from, to, description);
		Experience exp4 = new Experience("", "", "", "", "", "");
		exps.add(exp1);
		exps.add(exp2);
		exps.add(exp3);
		exps.add(exp4);
		
		return exps;
	}
	
	public static ArrayList<HashMap<String, String>> getExpectedResult () {
		HashMap<String, String> scenario1 = new HashMap<>();
		scenario1.put("StatusCode", "200");
		scenario1.put("title", title);
		scenario1.put("company", company);
		scenario1.put("location", location);
		scenario1.put("from", from);
		scenario1.put("to", to);
		scenario1.put("description", description);
		
		HashMap<String, String> scenario2 = new HashMap<>();
		scenario2.put("StatusCode", "400");
		scenario2.put("title", "Job title field is required");
		
		HashMap<String, String> scenario3 = new HashMap<>();
		scenario3.put("StatusCode", "400");
		scenario3.put("company", "Company field is required");

		HashMap<String, String> scenario4 = new HashMap<>();
		scenario4.put("StatusCode", "400");
		scenario4.put("title", "Job title field is required");
		scenario4.put("company", "Company field is required");
		scenario4.put("from", "From date field is required");
		
		ArrayList<HashMap<String, String>> results = new ArrayList<>();
		results.add(scenario1);
		results.add(scenario2);
		results.add(scenario3);
		results.add(scenario4);
		
		return results;
	}
	
	
}
