package icd0004.unit;

import icd0004.api.WeatherApi;
import icd0004.api.dto.CurrentWeatherDto;
import icd0004.api.dto.MainDto;
import icd0004.handler.CurrentWeatherHandler;
import icd0004.report.CurrentWeatherReport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrentWeatherReportUnitTests {
    @Mock
    private WeatherApi weatherApiMock;

    @Test
    public void givenTemp_whenGetCurrentWeatherReport_thenReportShouldContainTemp(){
        Double temp = -5.0;
        CurrentWeatherDto weatherDtoStub = new CurrentWeatherDto();
        weatherDtoStub.setCity(anyString());
        MainDto mainDtoStub = new MainDto();
        mainDtoStub.setTemp(temp);
        weatherDtoStub.setMain(mainDtoStub);
        when(weatherApiMock.getCurrentWeatherData("Tallinn")).thenReturn(weatherDtoStub);
        CurrentWeatherHandler currentWeatherHandler = new CurrentWeatherHandler(weatherApiMock);
        CurrentWeatherReport currentWeatherReport = currentWeatherHandler.getCurrentWeatherReport(anyString());

        assertThat(currentWeatherReport.getTemperature()).isEqualTo(-5);
    }

    @Test
    public void givenPressure_whenGetCurrentWeatherReport_thenReportShouldContainPressure(){
        int press = 1020;
        CurrentWeatherDto weatherDtoStub = new CurrentWeatherDto();
        weatherDtoStub.setCity(anyString());
        MainDto mainDtoStub = new MainDto();
        mainDtoStub.setPressure(press);
        weatherDtoStub.setMain(mainDtoStub);
        when(weatherApiMock.getCurrentWeatherData("Tallinn")).thenReturn(weatherDtoStub);
        CurrentWeatherHandler currentWeatherHandler = new CurrentWeatherHandler(weatherApiMock);
        CurrentWeatherReport currentWeatherReport = currentWeatherHandler.getCurrentWeatherReport(anyString());

        assertThat(currentWeatherReport.getPressure()).isEqualTo(press);
    }

    @Test
    public void givenDate_whenGetCurrentWeatherReport_thenReportDatesAreRightFormat(){
        CurrentWeatherDto weatherDtoStub = new CurrentWeatherDto();
        weatherDtoStub.setCity(anyString());
        MainDto mainDtoStub = new MainDto();
        weatherDtoStub.setMain(mainDtoStub);
        weatherDtoStub.setDate(1669399200);
        when(weatherApiMock.getCurrentWeatherData("Tallinn")).thenReturn(weatherDtoStub);
        CurrentWeatherHandler currentWeatherHandler = new CurrentWeatherHandler(weatherApiMock);
        CurrentWeatherReport currentWeatherReport = currentWeatherHandler.getCurrentWeatherReport(anyString());

        assertThat(currentWeatherReport.getDate()).isNotEqualTo("2022-11-25");
        assertThat(currentWeatherReport.getDate()).isEqualTo("25-11-2022");
    }
}
