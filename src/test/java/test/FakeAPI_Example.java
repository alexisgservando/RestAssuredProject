package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FakeAPI_Example {

	@Test
	public void test01_GET()
	{
		baseURI = "http://localhost:3000/";
		given()
		.param("name", "DevOps")
		.get("/subjects")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void test02_POST()
	{
		JSONObject request = new JSONObject();
		request.put("firstName", "Alexis");
		request.put("lastName", "Guardado");
		request.put("subjectId", "1");
		
		baseURI = "http://localhost:3000/";
		
		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json")
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201)
		.log().all();
	}
	
	@Test
	public void test03_PATCH()
	{
		JSONObject request = new JSONObject();
		request.put("lastName", "Servando");
		
		baseURI = "http://localhost:3000/";
		
		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json")
		.body(request.toJSONString())
		.when()
		.patch("/users/4")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void test04_PUT()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Alex");
		request.put("lastName", "Guardado");
		request.put("subjectId", "1");
		
		baseURI = "http://localhost:3000/";
		
		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json")
		.body(request.toJSONString())
		.when()
		.put("/users/4")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	public void test05_DELETE()
	{
		baseURI = "http://localhost:3000/";
		
		when()
		.delete("/users/4")
		.then()
		.statusCode(200)
		.log().all();
	}
}
