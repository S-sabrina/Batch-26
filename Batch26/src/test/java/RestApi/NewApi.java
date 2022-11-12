package RestApi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewApi {
	
	String domain = "";
	
	@Test
	public void curdOps() {
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, domain + "");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
	}

}
