package icd0004.integration;

import icd0004.api.WeatherApi;
import icd0004.api.dto.CurrentWeatherDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MainDetailsIntegrationTests {
    private static final String CITY = "Southampton";
    private static WeatherApi weatherApi;

    @BeforeEach
    public void initWeatherApi() {
        weatherApi = new WeatherApi();
    }

    @Test
    public void givenCityName_whenMakeRequestToOwmWeatherEndpoint_thenShouldHaveCityInDto() {
        CurrentWeatherDto actualDto = weatherApi.getCurrentWeatherData(CITY);

        assertThat(actualDto.getCity()).isEqualTo(CITY);
    }

    @Test
    public void givenCityName_whenMakeRequestToOwnWeatherEndpoint_thenShouldHaveCoordinatesInDto() {
        Double expectedLat = 50.904;
        Double expectedLon = -1.4043;

        CurrentWeatherDto actualDto = weatherApi.getCurrentWeatherData(CITY);

        assertThat(actualDto.getCoordinates()).extracting("lat", "lon")
                .contains(expectedLat, expectedLon);
    }

}
