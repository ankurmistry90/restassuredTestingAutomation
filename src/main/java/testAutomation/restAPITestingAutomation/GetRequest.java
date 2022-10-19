package testAutomation.restAPITestingAutomation;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest {
	
	public Response get(String name){

		Response response=RestAssured.
			given().baseUri("https://restcountries.com")
			.when().get("/v3.1/name/"+name);
		
		return response;
	
	}
	
	
	public List<String> getCapitalcityCount(Response response){
		List<String> capitals = new ArrayList<String>();
		JsonPath jp =response.jsonPath();
		
		List<Object> totalArray = jp.getList(".");
		System.out.println(totalArray.size());
	    
		for (int i=0;i<totalArray.size();i++){
			
			String capital= jp.getString("["+i+"].capital");
			
			capitals.add(capital);
			
		}
	
	return capitals;
	
	}

}
