package icd0004.handler;

import icd0004.api.WeatherApi;
import icd0004.api.dto.CoordinatesDto;
import icd0004.api.dto.CurrentWeatherDto;
import icd0004.report.MainDetails;

import java.text.DecimalFormat;

public class MainDetailsHandler {
    private final WeatherApi weatherApi;

    public MainDetailsHandler() {
        this.weatherApi = new WeatherApi();
    }

    public MainDetailsHandler(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public MainDetails getMainDetails(String city) {
        CurrentWeatherDto weatherDto = weatherApi.getCurrentWeatherData(city);

        return mapDetailsToReport(weatherDto);
    }

    private MainDetails mapDetailsToReport(CurrentWeatherDto weatherDto) {
        MainDetails mainDetails = new MainDetails();
        mainDetails.setCity(weatherDto.getCity());
        mainDetails.setCoordinates(formatCoordinatesToString(weatherDto));
        mainDetails.setTemperatureUnit("Celsius");
        return mainDetails;
    }

    private String formatCoordinatesToString(CurrentWeatherDto weatherDto) {
        Double lat = weatherDto.getCoordinates().getLat();
        Double lon = weatherDto.getCoordinates().getLon();
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(lat) + "," + df.format(lon);
    }
}
