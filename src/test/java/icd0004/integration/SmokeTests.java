package icd0004.integration;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class SmokeTests {
    public static final String CURRENT_WEATHER_API = "https://api.openweathermap.org/data/2.5/weather";
    public static final String API_KEY = "f5fed9c8b74174a5c021904ade8402a5";
    public static final String CITY_NAME = "Southampton";

    @Test
    public void givenNoApiKey_thenShouldReturn401() {
        given()
                .when()
                .get(CURRENT_WEATHER_API)
                .then()
                .statusCode(401);
    }

    @Test
    public void givenWorkingApiKey_thenShouldReturn200() {
        given()
                .queryParam("appid", API_KEY)
                .queryParam("q", CITY_NAME)
                .when()
                .get(CURRENT_WEATHER_API)
                .then()
                .statusCode(200);
    }

    @Test
    public void givenCityName_whenGetCurrentWeather_thenResponseContainsCoordinateProperties() {
        given()
                .queryParam("appid", API_KEY)
                .queryParam("q", CITY_NAME)
                .when()
                .get(CURRENT_WEATHER_API)
                .then()
                .statusCode(200)
                .body("$", hasKey("coord"))
                .body("coord", hasKey("lon"))
                .body("coord", hasKey("lat"));

    }

    @Test
    public void givenCityName_whenGetCurrentWeather_thenContainsCityNameInResponse() {
        given()
                .queryParam("appid", API_KEY)
                .queryParam("q", CITY_NAME)
                .when()
                .get(CURRENT_WEATHER_API)
                .then()
                .body("name", equalTo(CITY_NAME));
    }

}
