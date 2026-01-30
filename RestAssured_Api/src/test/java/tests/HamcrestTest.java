package tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


public class HamcrestTest {
	
	@Test
	public void basicHamcrestValidation() {

	    given()
	        .when()
	            .get("https://postman-echo.com/get?foo=bar")
	        .then()
	            .statusCode(200)
	            .contentType("application/json")
	            .body("args.foo", equalTo("bar"))
	            .body("url", containsString("postman-echo.com"))
	            .body("headers.host", equalTo("postman-echo.com"))
	            /*
	        	 * Sample response { "ids": [1, 2, 3, 4] }
	        	 */
	            
	            .body("ids", hasSize(4))
	            .body("ids", hasItems(1, 3))
	            .body("ids", everyItem(greaterThan(0)))
	   
	     //6️⃣ NULL / NOT NULL / EMPTY CHECKS
	    .body("headers.authorization", notNullValue())
	    .body("headers.authorization", not(equalTo("")))
	  //7️⃣ STRING VALIDATIONS
	    
	    .body("url", startsWith("https"))
	    .body("url", containsString("postman"))
	    .body("url", endsWith("/get"))
	    
	  //8️⃣ NUMBER VALIDATIONS
	    
	    .body("status", greaterThanOrEqualTo(200))
	    .body("status", lessThan(300))
	    
	   // 9️⃣ MULTIPLE ASSERTIONS (Best practice)
	    .body("headers", hasKey("host"))
	    .body("headers", hasEntry("host", "postman-echo.com"))
	   
	   // 🔟 VALIDATE RESPONSE TIME
	    .time(lessThan(2000L))
	    
		/*
		 * 1️⃣1️⃣ ADVANCED – JSON PATH FILTER 
		 * Sample response { "users": [ { "name":
		 * "Vanish", "role": "QA" }, { "name": "Anjali", "role": "Developer" } ] }
		 */
	    .body("users.find { it.name == 'Vanish' }.role",
	            equalTo("QA"))
	    
	    ///MATCH ENTIRE JSON STRUCTURE (Partial)
	    .body("headers", allOf(
	            hasKey("host"),
	            hasKey("user-agent")));
	    
	    

	    
	}
	
	


}
