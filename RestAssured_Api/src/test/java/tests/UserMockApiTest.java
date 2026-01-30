package tests;

import base.BaseMockTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserMockApiTest extends BaseMockTest {

    @Test
    public void getUserMockTest() {

        given()
        .when()
            .get("http://localhost:8089/users/1")
        .then()
            .statusCode(200)
            .body("name", equalTo("Vanish"))
            .body("role", equalTo("QA"));
    }
}
