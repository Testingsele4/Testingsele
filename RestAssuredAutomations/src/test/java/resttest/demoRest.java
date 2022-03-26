package resttest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class demoRest {
	
	
	// Testing

	@Test
	public void test() {

		/*		  //Specify base URI
		 RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();

		  //Response object
		  Response response=httpRequest.request(Method.GET,"/Hyderabad")*/;

		  Response response=given().get("https://reqres.in/api/users?page=2");
		  int Statuscode =response.getStatusCode();
		  Assert.assertEquals(Statuscode, 200);

		  String statusline = response.statusLine();
		  Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	@Test
	public void test2() {

		baseURI= "https://reqres.in/api";

		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].id", equalTo(9)).
			log().all();


	}


}

