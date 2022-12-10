package icd0004.handler;

import icd0004.api.WeatherApi;
import icd0004.api.dto.CurrentWeatherDto;
import icd0004.report.CurrentWeatherReport;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        if(weatherDto.getMain() == null){
            return null;
        }
        return mapCurrentWeatherDataToReport(weatherDto);
    }

    private CurrentWeatherReport mapCurrentWeatherDataToReport(CurrentWeatherDto weatherDto) {
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport();
        currentWeatherReport.setTemperature((int) Math.round(weatherDto.getMain().getTemp()));
        currentWeatherReport.setPressure(weatherDto.getMain().getPressure());
        currentWeatherReport.setHumidity(weatherDto.getMain().getHumidity());
        currentWeatherReport.setDate(formatDateToString(weatherDto));

        return currentWeatherReport;
    }

    private String formatDateToString(CurrentWeatherDto weatherDto) {
        Date date = new Date(weatherDto.getDate() * 1000);
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MM-yyyy");

        return formattedDate.format(date);
    }
}
