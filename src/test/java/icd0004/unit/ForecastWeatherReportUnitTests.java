package icd0004.unit;

import icd0004.api.WeatherApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ForecastWeatherReportUnitTests {

    @Mock
    private WeatherApi weatherApiMock;

    @Test
    public void givenCity_whenForecastReport_thenReportShouldContainDate() {

    }

    @Test
    public void givenCity_whenForecastReport_thenReportShouldContainTemperature() {

    }

    @Test
    public void givenCity_whenForecastReport_thenReportShouldContainPressure() {

    }

    @Test
    public void givenCity_whenForecastReport_thenReportShouldContainHumidity() {

    }
}
