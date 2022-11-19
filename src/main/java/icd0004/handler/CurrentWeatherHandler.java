package icd0004.handler;

import icd0004.api.WeatherApi;
import icd0004.api.dto.CurrentWeatherDto;
import icd0004.report.CurrentWeatherReport;

public class CurrentWeatherHandler {

    private final WeatherApi weatherApi;

    public CurrentWeatherHandler() {
        this.weatherApi = new WeatherApi();
    }

    public CurrentWeatherHandler(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public CurrentWeatherReport getCurrentWeatherReport(String city) {
        CurrentWeatherDto weatherDto = weatherApi.getCurrentWeatherData(city);

        return mapCurrentWeatherDataToReport(weatherDto);
    }

    private CurrentWeatherReport mapCurrentWeatherDataToReport(CurrentWeatherDto weatherDto) {
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport();
        currentWeatherReport.setTemperature(weatherDto.getMain().getTemp());
        currentWeatherReport.setPressure(weatherDto.getMain().getPressure());
        currentWeatherReport.setHumidity(weatherDto.getMain().getHumidity());
        return currentWeatherReport;
    }
}
