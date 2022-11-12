package RestApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Restpractice {
	
	String domain = " http://restapi.adequateshop.com";
	
	@Test(enabled=false)
	public void curdOps() {
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, domain + "/api/v1/employees");
		
		String responseBody = response.getBody().asString();
		//System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		String contentType = response.contentType();
		Assert.assertEquals(contentType, "application/json");
		
	
	}
	
	@Test
	public void postMethod() {
		
		RequestSpecification httpReq = RestAssured.given();
		
		JSONObject data = new JSONObject();
		data.put("First_name", "sabrina");
		data.put("last_name", "moha");
		data.put("company_name", "google");
		
		Response resp = httpReq.request(Method.POST, domain + "/api/Tourist");
		String responsebdy = resp.getBody().asString();
		
		httpReq.contentType("applications/json");
		httpReq.request(data.toJSONString());
		
		String responseBdy = resp.getBody().asString();
		System.out.println(responseBdy);
		
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = resp.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 ok");
		
		String contentTyp = resp.contentType();
		Assert.assertEquals(contentTyp, "applictions/json");
				
		
		
	}

}
