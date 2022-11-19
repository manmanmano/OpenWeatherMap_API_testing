package icd0004.unit;

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
