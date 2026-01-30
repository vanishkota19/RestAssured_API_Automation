package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.RetryUtils;

import static io.restassured.RestAssured.given;

public class RetrySampleTest {
	
	@Test
	public void retryExampleTest() {

	    Response response = RetryUtils.retry(
	            () -> given().get("https://postman-echo.com/get"),
	            3,
	            2000
	    );

	    response.then()
	            .statusCode(200);
	}


}
