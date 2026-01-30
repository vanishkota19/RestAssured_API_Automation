package client;

import io.restassured.response.Response;
import pojo.LoginRequest;
import pojo.RefreshRequest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthClient {

    public static Response login(LoginRequest request) {
        return given()
                .contentType(JSON)
                .accept(JSON)
                .body(request)
                .post("/auth/login");
    }

    public static Response getCurrentUser(String accessToken) {
        return given()
                .accept(JSON)
                .header("Authorization", "Bearer " + accessToken)
                .get("/auth/me");
    }

    public static Response refreshToken(RefreshRequest request) {
        return given()
                .contentType(JSON)
                .accept(JSON)
                .body(request)
                .post("/auth/refresh");
    }
}
