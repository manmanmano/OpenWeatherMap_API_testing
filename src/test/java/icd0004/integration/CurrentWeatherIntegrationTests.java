package icd0004.integration;

import icd0004.handler.CurrentWeatherHandler;
import icd0004.report.CurrentWeatherReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentWeatherIntegrationTests {
    private CurrentWeatherReport currentWeatherReport;

    public static final String CITY = "Keila";

    @BeforeEach
    public void initializeCurrentWeatherHandler() {
        CurrentWeatherHandler currentWeatherHandler = new CurrentWeatherHandler();
        currentWeatherReport = currentWeatherHandler.getCurrentWeatherReport(CITY);
    }

    @Test
    public void givenCity_whenGetCurrentWeatherReport_thenReportShouldContainTemperature() {
        assertThat(currentWeatherReport.getTemperature()).isNotNaN();
    }
    @Test
    public void givenCity_whenGetCurrentWeatherReport_thenReportShouldContainHumidity() {
        assertThat(currentWeatherReport.getHumidity()).isNotNull();
    }
}
