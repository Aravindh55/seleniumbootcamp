package test;

import static io.restassured.RestAssured.given;


import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import javax.annotation.meta.When;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class test1 {

	public static void main(String[] args) {
		
		//add
		RestAssured.baseURI = "http://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
				.body(test1.test())
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)").extract()
				.response().asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
	String newaddress = "chennai,india";
		
		//update
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newaddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("/maps/api/place/update/json").then().log().all().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		//get
		String response2 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json").then().log().all().statusCode(200).extract().response()
		.asString();
		JsonPath json = new JsonPath(response2);
		String expectedaddresss = json.getString("address");
		Assert.assertEquals(newaddress, expectedaddresss);
	
	}
	public static String test() {
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
	}
	}


