package RaiDenZ.ApiAutomation;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestRunner {
	
	public static void main(String[] args) {

		
		
		ValidateTools.validateWithLoop(GetAllPosts.getAllPosts(), "text");
		
		
		ValidateTools.validatePostWithId(GetPostById.getPostById(DataProvider.postId), "id", DataProvider.postId);
		
		
		ValidateTools.validateNewPost(CreatANewPost.creatANewPost(DataProvider.token, DataProvider.MapDataForNewPost().get(1)), DataProvider.MapDataForNewPost().get("valid data"), 200);
		
		for(Object key: DataProvider.MapDataForNewPost().keySet()) {
			
			System.out.println(key);
			
			ValidateTools.validateNewPost(CreatANewPost.creatANewPost(DataProvider.token, DataProvider.MapDataForNewPost().get(key)), DataProvider.MapDataForNewPost().get(key), 200);

		}
		

		ValidateTools.validateDeletePost(DeleteAPost.deleteAPost(CreatANewPost.idInNewPostToDelete(), DataProvider.token));
		
		
		ValidateTools.validateDeletePost(DeleteAPost.deleteAPost(DataProvider.postIdFromOthers, DataProvider.token));

		
}
}
