package icd0004.integration;

public class CurrentWeatherIntegrationTests {
    private CurrentWeatherReport currentWeatherReport;

    public static final String CITY = "Keila";

    @BeforeEach
    public void initializeCurrentWeatherHandler() {
        CurrentWeatherHandler currentWeatherHandler = new CurrentWeatherHandler();
        currentWeatherReport = currentWeatherHandler.getCurrentWeatherReport(CITY);
    }

    @Test
    public void givenCity_whenGetCurrentWeatherReport_thenReportShouldContainCity() {
        assertThat(currentWeatherReport.getCity()).isEqualTo("Keila");

    }

    @Test
    public void givenCity_whenGetCurrentWeatherReport_thenReportShouldContainTemperature() {
        assertThat(currentWeatherReport.getTemperature()).isNotNaN();
    }

}
