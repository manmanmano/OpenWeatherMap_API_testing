package icd0004.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherIntegrationTests {
    public static final String CITY = "Coventry";
    public static final Weather weather;
    @BeforeEach
    public void initialiseWeather(){
        WeatherHandler weatherHandler = new WeatherHandler();
        weather = weatherHandler.getWeather(city);
    }
    @Test
    public void givenCity_weatherContainsCity(){
        assertThat(weather.getMainDetails().getCity).isEqualto(CITY);
    }
}
