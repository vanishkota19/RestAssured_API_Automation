package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }
}
