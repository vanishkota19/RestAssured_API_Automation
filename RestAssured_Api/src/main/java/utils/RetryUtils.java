package utils;

import io.restassured.response.Response;

import java.util.function.Supplier;

public class RetryUtils {

    public static Response retry(
            Supplier<Response> apiCall,
            int maxAttempts,
            long waitMillis) {

        Response response = null;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            response = apiCall.get();

            if (response.getStatusCode() == 200) {
                return response;
            }

            try {
                Thread.sleep(waitMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Retry interrupted");
            }
        }

        return response; // return last response if all retries fail
    }
}
