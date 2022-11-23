package icd0004.handler;

import icd0004.api.WeatherApi;
import icd0004.api.dto.ForecastWeatherDto;
import icd0004.report.ForecastReport;
import icd0004.report.ForecastWeather;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ForecastWeatherHandler {

    private final WeatherApi weatherApi;

    public ForecastWeatherHandler() {
        this.weatherApi = new WeatherApi();
    }

    public ForecastWeatherHandler(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public ForecastReport getForecastWeatherReport(String city) {
        ForecastWeatherDto weatherDto = weatherApi.getForecastWeatherData(city);

        return mapForecastWeatherDataToReport(weatherDto);
    }

    private ForecastReport mapForecastWeatherDataToReport(ForecastWeatherDto weatherDto) {
        ForecastReport forecastReport = new ForecastReport();
        forecastReport.setDate(formatDateToString(weatherDto));
        ForecastWeather forecastWeather = new ForecastWeather();
        forecastWeather.setPressure(weatherDto.getMain().getPressure());
        forecastWeather.setHumidity(weatherDto.getMain().getHumidity());
        forecastWeather.setTemperature(weatherDto.getMain().getTemp());
        forecastReport.setWeather(forecastWeather);
        return forecastReport;
    }

    private String formatDateToString(ForecastWeatherDto weatherDto) {
        Date date = new Date(weatherDto.getDate()*1000);
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");

        return formattedDate.format(date);
    }
}
