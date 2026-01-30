package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseExtentTest;
import base.BaseTest;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

@Listeners(listeners.ExtentTestListener.class)
public class ExtentReportTestCases extends BaseTest {
	
	    @Test
	    public void extentReportApiTest() {

	        Response response =
	            given()
	            .when()
	                .get("https://postman-echo.com/get");

	        BaseExtentTest.getTest()
	                .info("GET Response:\n" + response.asPrettyString());

	        response.then().statusCode(200);
	    }
	}



