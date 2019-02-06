package RaiDenZ.ApiAutomation;

import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ValidateTools {

    public static void validateWithLoop(Response actualResponse, String expectedMessage) {
    	int fail = 0;
    	 if(actualResponse.statusCode() != 200) {
             
             System.out.println("Step fail! Status code doesn't match!");
             fail++;
         }else {
         	System.out.println("Step pass! Status code matches!");
         }
    	
        JsonPath jP = actualResponse.jsonPath();
        ArrayList<HashMap> postsArray = jP.get("");      
        
        HashMap<String, String> posts = new HashMap<String, String>();
        
        int count = 0;
        int count2 = 0;
        for(int i=0;i<postsArray.size();i++) {
        	
        	if(postsArray.get(i).size() != 7) {
        		
        		count++;
        		
        		
        	}
            
            for(String key:posts.keySet()) {
                if(!key.equals(expectedMessage) || posts.get(expectedMessage).equals(null)) {
                    
                   count2++;
                    
                }
            }
        }
        
        if(count>0) {
        	System.out.println("Step fail! There are not 7 attribute!");
        	fail++;
        }else {
        	System.out.println("Step pass! There are 7 attribute!");
        }
        
        if(count2>0) {
        	 System.out.println("Step fail! Message doesn't match!");
        	 fail++;
        }else {
        	 System.out.println("Step pass! Message matchs!");
        }
        
       if(fail>0) {
    	   System.out.println("Test case: fail!");
       }else if(fail==0) {
    	   System.out.println("Test case: pass!");
       }
        System.out.println("--------------------------------------------------------------------------------");
        
}
    
    public static void validatePostWithId(Response actualResponse, String expectedMessage, String id) {
    	
    	int fail = 0;
    	 if(actualResponse.statusCode() != 200) {
             
             System.out.println("Step fail! Status code doesn't match!");
             fail++;
             
         }else {
         	System.out.println("Step pass! Status code matches!");
         }
    	
    	JsonPath jP = actualResponse.jsonPath();
        ArrayList<HashMap> postsArray = jP.get("");
        
    
        
        HashMap<String, String> posts = new HashMap<String, String>();
        
        int count = 0;
        int count2 = 0;
        for(int i=0;i<postsArray.size();i++) {
        	
        	if(postsArray.get(i).size() != 7) {
        		
        		count++;
        		
        		
        	}
            
            for(String key:posts.keySet()) {
                if(!key.equals(expectedMessage) || posts.get(expectedMessage).equals(id)) {
                    
                   count2++;
                    
                }
            }
        }
        
        if(count>0) {
        	System.out.println("Step fail! There are not 7 attribute!");
        	fail++;
        }else {
        	System.out.println("Step pass! There are 7 attribute!");
        }
        
        if(count2>0) {
        	 System.out.println("Step fail! Id doesn't match!");
        	 fail++;
        }else {
        	 System.out.println("Step pass! Id matchs!");
        }
        
        if(postsArray.size() != 1) {
     	   System.out.println("Test fail! There are more than 1 post with same id!");
     	   fail++;
        }
        if(fail>0) {
     	   System.out.println("Test case: fail!");
        }else if(fail==0) {
     	   System.out.println("Test case: pass!");
        }
        
        System.out.println("--------------------------------------------------------------------------------");
    	
    }
    
    public static void validateNewPost(Response actualResponse, Object object, int expectedStatusCode) {
    	
    	int fail = 0;
    	
    	 if(actualResponse.statusCode() != expectedStatusCode) {
             
             System.out.println("Step fail! Status code doesn't match! Status code is: " + actualResponse.statusCode());
             
             fail++;
             
         }else {
         	System.out.println("Step pass! Status code matches!");
         }
    	  
    	  JsonPath jP = actualResponse.jsonPath();
          HashMap<String, String> newPost = jP.get("");
          
          int count = 0;
          
         for(String key:newPost.keySet()) {
        	 
        	 if(key.equals("text") && newPost.get("text").equals(object)) {
        		 count++;
        	 }
         }
         
         if(count!=1) {
        	 System.out.println("Step fail! Text doesn't match!");
        	 
        	 fail++;
         }else {
        	 System.out.println("Step pass! Text matches!");
         }
         
         if(fail>0) {
       	   System.out.println("Test case: fail!");
          }else if(fail==0) {
       	   System.out.println("Test case: pass!");
          }
          
          System.out.println("--------------------------------------------------------------------------------");
      }
    
    
    	public static void validateDeletePost(Response actualResponse) {
    		HashMap<String,String> responseBody = actualResponse.jsonPath().get("");
    		
    		 if(responseBody.containsValue("User not authorized") && actualResponse.statusCode() == 401) {
                 
                 System.out.println("Test fail! User not authorized! Status code matches! Status code is: " + actualResponse.statusCode());
                 
    		 }else if(responseBody.containsValue(true) && actualResponse.statusCode() == 200 ) {
    			 
    			   System.out.println("Test pass! Delete successes! Status code matches! Status code is: " + actualResponse.statusCode());
    			   
             }else {
            	 
             	System.out.println("Step fail! Status code doesn't match!");
             }
    		 
    		 System.out.println("--------------------------------------------------------------------------------");
    		 
    	}
    
    }



