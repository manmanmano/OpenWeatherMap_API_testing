package icd0004.handler;

import icd0004.api.WeatherApi;
import icd0004.api.dto.CurrentWeatherDto;
import icd0004.report.CurrentWeatherReport;

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

    private CurrentWeatherReport mapDetailsToReport(CurrentWeatherDto weatherDto) {
        MainDetails mainDetails = new MainDetails();
        mainDetails.setCity(weatherDto.getCity());
        return mainDetails;
    }
}
