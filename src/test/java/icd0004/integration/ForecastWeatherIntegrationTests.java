package icd0004.integration;

import icd0004.handler.ForecastWeatherHandler;
import icd0004.report.ForecastReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ForecastWeatherIntegrationTests {
    private ForecastReport forecastReport;

    public static final String CITY = "Tartu";

    @BeforeEach
    public void initializeForecastWeatherHandler() {
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler();
        forecastReport = forecastWeatherHandler.getForecastWeatherReport(CITY);
    }

    @Test
    public void givenCity_whenGetForecastReport_thenReportShouldContainDate() {
        assertThat(forecastReport.getDate()).isNotNull();
    }

    @Test
    public void givenCity_whenGetForecastReport_thenReportShouldContainTemperature() {
        assertThat(forecastReport.getWeather().getTemperature()).isNotNaN();
    }

    @Test
    public void givenCity_whenGetForecastReport_thenReportShouldContainHumidity() {
        assertThat(forecastReport.getWeather().getHumidity()).isNotNull();
    }

    @Test
    public void givenCity_whenGetForecastReport_thenReportShouldContainPressure() {
        assertThat(forecastReport.getWeather().getPressure()).isNotNull();
    }
}
