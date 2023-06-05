package test;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class Test05_DELETE {
	
	@Test
	public void test01()
	{
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log().all();                                              //To log the response and check everything is ok
	}
}
