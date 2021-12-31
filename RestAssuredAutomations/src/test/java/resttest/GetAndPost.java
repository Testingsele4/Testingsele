package resttest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import javax.management.ObjectInstance;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
public class GetAndPost {
	
	
	//@Test
/*	public void GetMethos() {
		
		
		baseURI= "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].first_name", equalTo("Tobias")).
			body("data.first_name", hasItems("Byron","George","Rachel")).
			log().
			all();
		
	}
	*/	
		@Test
		public void PostMethod(){
			
			Map<String, Object>map = new HashMap<String, Object>();
			
			/*map.put("\"name\"", "morpheus");
			map.put("\"job", "leader");
			System.out.println(map);*/

			
			JSONObject json = new JSONObject();
			
			json.put("name", "morpheus");
			json.put("job", "leader");
			
			baseURI= "https://reqres.in/api";
			
			given().
				header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).	
			when().
				post("/users").
			then().
			statusCode(201).
			log().all();
					
		}

}
