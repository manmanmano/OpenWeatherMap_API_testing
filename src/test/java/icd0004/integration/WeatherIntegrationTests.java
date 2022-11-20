package icd0004.integration;

import icd0004.handler.WeatherHandler;
import icd0004.report.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherIntegrationTests {
    public static final String CITY = "Coventry";
    private Weather weather;
    @BeforeEach
    public void initialiseWeather(){
        WeatherHandler weatherHandler = new WeatherHandler();
        weather = weatherHandler.getWeather(CITY);
    }
    @Test
    public void givenCity_weatherContainsCity(){
        assertThat(weather.getMainDetails().getCity()).isEqualTo(CITY);
    }
}
