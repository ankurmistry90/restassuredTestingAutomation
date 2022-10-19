package testAutomation.restAPITestingAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestMethods {
	
	@Test
	public void tc1_fullName(){
		GetRequest req= new GetRequest();
		Response response= req.get("Wallis and Futuna");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(req.getCapitalcityCount(response).size()>0);
	}
	
	
	@Test
	public void tc2_PartialName(){
		GetRequest req= new GetRequest();
		Response response= req.get("United");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(req.getCapitalcityCount(response).size()>0);
	}
	
	@Test
	public void tc3_PartialNamewithTwoCharacters(){
		GetRequest req= new GetRequest();
		Response response= req.get("Un");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(req.getCapitalcityCount(response).size()>0);
	}
	
	@Test
	public void tc4_PartialNamewithOneCharacter(){
		GetRequest req= new GetRequest();
		Response response= req.get("U");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(req.getCapitalcityCount(response).size()>0);
	}
	
	@Test
	public void tc5_InvalidName(){
		GetRequest req= new GetRequest();
		Response response= req.get("Utt");
		Assert.assertEquals(response.getStatusCode(), 404);
	}

}
