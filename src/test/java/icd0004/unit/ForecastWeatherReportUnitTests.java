package icd0004.unit;

import icd0004.api.WeatherApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForecastWeatherReportUnitTests {

    @Mock
    private WeatherApi weatherApiMock;

    @Test
    public void givenDate_whenForecastReport_thenReportShouldContainDate() {
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        forecastWeatherDtoStub.setDate(1661871600);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastWeatherDtoStub);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ForecastWeatherReport forecastWeatherReport = forecastWeatherHandler.getForecastWeatherReport(anyString());

        assertThat(forecastWeatherReport.getDate()).isEqualTo("2022-08-30");
    }

    @Test
    public void givenTemperature_whenForecastReport_thenReportShouldContainTemperature() {
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        forecastWeatherDtoStub.setTemperature(10.0);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastWeatherDtoStub);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ForecastWeatherReport forecastWeatherReport = forecastWeatherHandler.getForecastWeatherReport(anyString());

        assertThat(forecastWeatherReport.getForecastWeather().getTemperature()).isEqualTo(10.0);
    }

    @Test
    public void givenPressure_whenForecastReport_thenReportShouldContainPressure() {
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        forecastWeatherDtoStub.setPressure(1023);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastWeatherDtoStub);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ForecastWeatherReport forecastWeatherReport = forecastWeatherHandler.getForecastWeatherReport(anyString());

        assertThat(forecastWeatherReport.getForecastWeather().getPressure()).isEqualTo(1023);
    }

    @Test
    public void givenHumidity_whenForecastReport_thenReportShouldContainHumidity() {
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        forecastWeatherDtoStub.setHumidity(91);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastWeatherDtoStub);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ForecastWeatherReport forecastWeatherReport = forecastWeatherHandler.getForecastWeatherReport(anyString());

        assertThat(forecastWeatherReport.getForecastWeather().getHumidity()).isEqualTo(91);
    }
}
