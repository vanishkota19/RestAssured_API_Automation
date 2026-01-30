package utils;

import base.BaseExtentTest;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;

public class ExtentLogger {

    // Generic info
    public static void logInfo(String message) {
        BaseExtentTest.getTest().log(Status.INFO, message);
    }

    // Log API request
    public static void logRequest(String method, String endpoint) {
        BaseExtentTest.getTest().log(
                Status.INFO,
                "REQUEST ➜ " + method + " " + endpoint
        );
    }

    // Log response body
    public static void logResponse(Response response) {
        BaseExtentTest.getTest().log(
                Status.INFO,
                "RESPONSE (" + response.getStatusCode() + ")\n"
                        + response.asPrettyString()
        );
    }

    // Log success
    public static void logPass(String message) {
        BaseExtentTest.getTest().log(Status.PASS, message);
    }

    // Log failure
    public static void logFail(Throwable error) {
        BaseExtentTest.getTest().log(Status.FAIL, error);
    }
}
