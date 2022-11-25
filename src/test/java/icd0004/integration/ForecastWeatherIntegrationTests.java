package icd0004.integration;

import icd0004.handler.ForecastWeatherHandler;
import icd0004.report.ForecastReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ForecastWeatherIntegrationTests {
    private ArrayList<ForecastReport> forecastReport;

    public static final String CITY = "Tartu";

    @BeforeEach
    public void initializeForecastWeatherHandler() {
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler();
        forecastReport = forecastWeatherHandler.getForecastWeatherReport(CITY);
    }

    @Test
    public void givenCity_whenGetForecastReport_thenReportShouldContainDate() {
        for (int i = 0; i < 3; i++) {
            assertThat(forecastReport.get(i).getDate()).isNotNull();
        }
    }

    @Test
    public void givenCity_whenGetForecastReport_thenReportShouldContainHumidity() {
        for (int i = 0; i < 3; i++) {
            assertThat(forecastReport.get(i).getWeather().getHumidity()).isNotNull();
        }
    }

    @Test
    public void givenCity_whenGetForecastReport_thenReportShouldContainPressure() {
        for (int i = 0; i < 3; i++) {
            assertThat(forecastReport.get(i).getWeather().getPressure()).isNotNull();
        }
    }

    @Test
    public void givenCity_whenGetForecastReport_thenReportShouldContainTemperature() {
        for (int i = 0; i < 3; i++) {
            assertThat(forecastReport.get(i).getWeather().getTemperature()).isNotNull();
        }
    }
    @Test
    public void givenCity_forecastDatesAreDifferent(){
        assertThat(forecastReport.get(0).getDate()).isNotEqualTo(forecastReport.get(1).getDate());
        assertThat(forecastReport.get(1).getDate()).isNotEqualTo(forecastReport.get(2).getDate());
    }

}
