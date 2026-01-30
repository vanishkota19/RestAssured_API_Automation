package mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.*;



public class UserStubs {

    public static void stubUser1() {
        stubFor(get(urlEqualTo("/users/1"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{ \"id\":1, \"name\":\"Vanish\", \"role\":\"QA\" }")));
    }
}
