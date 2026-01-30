package tests;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


import static io.restassured.RestAssured.given;
public class SchemaValidation {

	
	@Test
	public void schemaValidationTest() {

	    given()
	    .when()
	        .get("https://postman-echo.com/get")
	    .then()
	        .statusCode(200)
	        .body(matchesJsonSchemaInClasspath("schemas/get-schema.json"));
	}

}
