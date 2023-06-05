package test;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Test04_PUT {

	@Test
	public void test01()
	{
		JSONObject request = new JSONObject();
		request.put("name", "Alexis");
		request.put("job", "QA");
		
		System.out.println(request);
		
		given()
		.header("Content-Type", "application/json")                 //If there is no header, this line can be removed
		.contentType(ContentType.JSON).accept(ContentType.JSON)     //If there is no header, this line can be removed
		.body(request.toJSONString())
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();                                              //To log the response and check everything is ok
	}
}
