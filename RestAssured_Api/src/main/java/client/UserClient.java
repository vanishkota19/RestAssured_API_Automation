package client;

import io.restassured.response.Response;
import utils.RequestSpecFactory;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class UserClient {

    public static Response createUser(Object payload) {
        return given()
        		.contentType(ContentType.JSON)
                .spec(RequestSpecFactory.getRequestSpec())
                .body(payload)
                .post("/users");
    }
}
