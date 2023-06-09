package icd0004.unit;

import icd0004.api.WeatherApi;
import icd0004.api.dto.CoordinatesDto;
import icd0004.api.dto.CurrentWeatherDto;
import icd0004.handler.MainDetailsHandler;
import icd0004.report.MainDetails;
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
    public void givenCity_whenGetMainDetails_thenReportShouldContainCity(){
        String city = "Keila";
        CurrentWeatherDto weatherDtoStub = new CurrentWeatherDto();
        weatherDtoStub.setCity("Keila");
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setLat(0.0);
        coordinatesDto.setLon(0.0);
        weatherDtoStub.setCoordinates(coordinatesDto);
        when(weatherApiMock.getCurrentWeatherData(anyString())).thenReturn(weatherDtoStub);
        MainDetailsHandler mainDetailsHandler = new MainDetailsHandler(weatherApiMock);

        MainDetails mainDetails = mainDetailsHandler.getMainDetails(city);

        assertThat(mainDetails.getCity()).isEqualTo(city);
    }

    @Test
    public void givenCity_whenGetMainDetails_thenReportShouldContainCoordinates(){
        String city = "Tallinn";
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setLat(59.44);
        coordinatesDto.setLon(24.75);
        CurrentWeatherDto weatherDtoStub = new CurrentWeatherDto();
        weatherDtoStub.setCoordinates(coordinatesDto);
        when(weatherApiMock.getCurrentWeatherData(anyString())).thenReturn(weatherDtoStub);
        MainDetailsHandler mainDetailsHandler = new MainDetailsHandler(weatherApiMock);

        MainDetails mainDetails = mainDetailsHandler.getMainDetails(city);

        assertThat(mainDetails.getCoordinates()).isEqualTo("59.44,24.75");
    }

    @Test
    public void givenCity_whenGetMainDetails_thenReportShouldContainUnit(){
        String city = "Tallinn";
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setLat(0.0);
        coordinatesDto.setLon(0.0);
        CurrentWeatherDto weatherDtoStub = new CurrentWeatherDto();
        weatherDtoStub.setCoordinates(coordinatesDto);
        when(weatherApiMock.getCurrentWeatherData(anyString())).thenReturn(weatherDtoStub);
        MainDetailsHandler mainDetailsHandler = new MainDetailsHandler(weatherApiMock);

        MainDetails mainDetails = mainDetailsHandler.getMainDetails(city);

        assertThat(mainDetails.getTemperatureUnit()).isEqualTo("Celsius");
    }

}
