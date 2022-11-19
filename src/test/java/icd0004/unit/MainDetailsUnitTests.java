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
public class MainDetailsUnitTests {

    @Mock
    private WeatherApi weatherApiMock;

    @Test
    public void givenCity_whenGetCurrentWeatherReport_thenReportShouldContainCity(){
        String city = "Keila";
        CurrentWeatherDto weatherDtoStub = new CurrentWeatherDto();
        weatherDtoStub.setCity("Keila");
        weatherDtoStub.setMain(new MainDto());
        when(weatherApiMock.getCurrentWeatherData(anyString())).thenReturn(weatherDtoStub);
        CurrentWeatherHandler currentWeatherHandler = new CurrentWeatherHandler(weatherApiMock);

        CurrentWeatherReport currentWeatherReport = currentWeatherHandler.getCurrentWeatherReport(city);

        assertThat(currentWeatherReport.getCity()).isEqualTo(city);
    }

}