package test;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;


public class Test03_POST {
	
	@Test
	public void test01()
	{
		/* OPTION 1: CREATE A MAP AND CONVERT IT TO JSONOBJECT
		 * 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Alexis");
		map.put("job", "QA");
		System.out.println(map);
		JSONObject request = new JSONObject(map);
		*/
		
		//OPTION 2 - CREATE JSONOBJECT
		JSONObject request = new JSONObject();
		request.put("name", "Alexis");
		request.put("job", "QA");
		
		System.out.println(request);
		//System.out.println(request.toJSONString());
		
		given()
		.header("Content-Type", "application/json")                 //If there is no header, this line can be removed
		.contentType(ContentType.JSON).accept(ContentType.JSON)     //If there is no header, this line can be removed
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201);
	}
}
