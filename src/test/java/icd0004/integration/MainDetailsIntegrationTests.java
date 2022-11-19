package icd0004.integration;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MainDetailsIntegrationTests {
    @Test
    public void weatherShouldReturnHttp400withNoCity(){
        given()
                .queryParam("appid", "f5fed9c8b74174a5c021904ade8402a5")
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather")
                .then()
                .statusCode(400);
    }
}
