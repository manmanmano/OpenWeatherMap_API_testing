package icd0004.unit;

import icd0004.api.WeatherApi;
import icd0004.api.dto.ForecastWeatherDto;
import icd0004.api.dto.MainDto;
import icd0004.handler.ForecastWeatherHandler;
import icd0004.report.ForecastReport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForecastWeatherReportUnitTests {

    @Mock
    private WeatherApi weatherApiMock;

    @Test
    public void givenDate_whenForecastReport_thenReportShouldContainDate() {
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        forecastWeatherDtoStub.setDate(1669626000);
        MainDto mainDtoStub = new MainDto();
        forecastWeatherDtoStub.setMain(mainDtoStub);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastWeatherDtoStub);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ForecastReport forecastWeatherReport = forecastWeatherHandler.getForecastWeatherReport(anyString());

        assertThat(forecastWeatherReport.getDate()).isEqualTo("2022-11-28");
    }

    @Test
    public void givenTemperature_whenForecastReport_thenReportShouldContainTemperature() {
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        MainDto mainDtoStub = new MainDto();
        mainDtoStub.setTemp(10.0);
        forecastWeatherDtoStub.setMain(mainDtoStub);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastWeatherDtoStub);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ForecastReport forecastWeatherReport = forecastWeatherHandler.getForecastWeatherReport(anyString());

        assertThat(forecastWeatherReport.getWeather().getTemperature()).isEqualTo(10.0);
    }

    @Test
    public void givenPressure_whenForecastReport_thenReportShouldContainPressure() {
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        MainDto mainDtoStub = new MainDto();
        mainDtoStub.setPressure(1023);
        forecastWeatherDtoStub.setMain(mainDtoStub);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastWeatherDtoStub);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ForecastReport forecastWeatherReport = forecastWeatherHandler.getForecastWeatherReport(anyString());

        assertThat(forecastWeatherReport.getWeather().getPressure()).isEqualTo(1023);
    }

    @Test
    public void givenHumidity_whenForecastReport_thenReportShouldContainHumidity() {
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        MainDto mainDtoStub = new MainDto();
        mainDtoStub.setHumidity(91);
        forecastWeatherDtoStub.setMain(mainDtoStub);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastWeatherDtoStub);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ForecastReport forecastWeatherReport = forecastWeatherHandler.getForecastWeatherReport(anyString());

        assertThat(forecastWeatherReport.getWeather().getHumidity()).isEqualTo(91);
    }
}
