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

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForecastWeatherReportUnitTests {

    @Mock
    private WeatherApi weatherApiMock;

    @Test
    public void givenDate_whenForecastReport_thenReportShouldContainDate() {
        ArrayList<ForecastWeatherDto> forecastList = new ArrayList<>();
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        forecastWeatherDtoStub.setDate(1669626000);
        MainDto mainDtoStub = new MainDto();
        forecastWeatherDtoStub.setMain(mainDtoStub);
        forecastList.add(forecastWeatherDtoStub);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastList);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ArrayList<ForecastReport> forecastWeatherReports = forecastWeatherHandler.getForecastWeatherReport(anyString());
        assertThat(forecastWeatherReports.get(0).getDate()).isEqualTo("2022-11-28");
    }

    @Test
    public void givenTemperature_whenForecastReport_thenReportShouldContainTemperature() {
        ArrayList<ForecastWeatherDto> forecastList = new ArrayList<>();
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        MainDto mainDtoStub = new MainDto();
        mainDtoStub.setTemp(10.0);
        forecastWeatherDtoStub.setMain(mainDtoStub);
        forecastList.add(forecastWeatherDtoStub);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastList);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ArrayList<ForecastReport> forecastWeatherReports = forecastWeatherHandler.getForecastWeatherReport(anyString());
        assertThat(forecastWeatherReports.get(0).getWeather().getTemperature()).isEqualTo(10.0);
    }

    @Test
    public void givenPressure_whenForecastReport_thenReportShouldContainPressure() {
        ArrayList<ForecastWeatherDto> forecastList = new ArrayList<>();
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        MainDto mainDtoStub = new MainDto();
        mainDtoStub.setPressure(1023);
        forecastWeatherDtoStub.setMain(mainDtoStub);
        forecastList.add(forecastWeatherDtoStub);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastList);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ArrayList<ForecastReport> forecastWeatherReports = forecastWeatherHandler.getForecastWeatherReport(anyString());
        assertThat(forecastWeatherReports.get(0).getWeather().getPressure()).isEqualTo(1023);
    }

    @Test
    public void givenHumidity_whenForecastReport_thenReportShouldContainHumidity() {
        ArrayList<ForecastWeatherDto> forecastList = new ArrayList<>();
        ForecastWeatherDto forecastWeatherDtoStub = new ForecastWeatherDto();
        MainDto mainDtoStub = new MainDto();
        mainDtoStub.setHumidity(91);
        forecastWeatherDtoStub.setMain(mainDtoStub);
        forecastList.add(forecastWeatherDtoStub);
        when(weatherApiMock.getForecastWeatherData(anyString())).thenReturn(forecastList);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApiMock);
        ArrayList<ForecastReport> forecastWeatherReports = forecastWeatherHandler.getForecastWeatherReport(anyString());
        assertThat(forecastWeatherReports.get(0).getWeather().getHumidity()).isEqualTo(91);
    }
}
