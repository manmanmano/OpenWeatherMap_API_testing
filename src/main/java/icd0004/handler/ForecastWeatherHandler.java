package icd0004.handler;

import icd0004.api.WeatherApi;
import icd0004.api.dto.ForecastResponseListDto;
import icd0004.api.dto.ForecastWeatherDto;
import icd0004.report.ForecastReport;
import icd0004.report.ForecastWeather;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ForecastWeatherHandler {

    private final WeatherApi weatherApi;

    public ForecastWeatherHandler() {
        this.weatherApi = new WeatherApi();
    }

    public ForecastWeatherHandler(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    private final int HOURS_PER_FORECAST = 3;
    private final int FORECAST_MAX_DAYS = 3;
    private final int FORECAST_MAX_DURATION = (FORECAST_MAX_DAYS * 24)/HOURS_PER_FORECAST;

    public ArrayList<ForecastReport> getForecastWeatherReport(String city) {
        ForecastResponseListDto forecastListDto = weatherApi.getForecastWeatherData(city);
        ArrayList<ForecastReport> forecastReport = new ArrayList<>();

        for (int i = Math.min(forecastListDto.getForecasts().size()-1, (FORECAST_MAX_DURATION / HOURS_PER_FORECAST)); i <= FORECAST_MAX_DURATION && i < forecastListDto.getForecasts().size(); i+=  (FORECAST_MAX_DURATION / HOURS_PER_FORECAST)) {
            ForecastWeatherDto forecastWeather = forecastListDto.getForecasts().get(i);
            forecastReport.add(mapForecastWeatherDataToReport(forecastWeather));
        }

        return forecastReport;
    }

    private ForecastReport mapForecastWeatherDataToReport(ForecastWeatherDto weatherDto) {
        ForecastReport forecastReport = new ForecastReport();
        forecastReport.setDate(formatDateToString(weatherDto));
        ForecastWeather forecastWeather = new ForecastWeather();
        forecastWeather.setPressure(weatherDto.getMain().getPressure());
        forecastWeather.setHumidity(weatherDto.getMain().getHumidity());
        forecastWeather.setTemperature((int)Math.round(weatherDto.getMain().getTemp()));
        forecastReport.setWeather(forecastWeather);
        return forecastReport;
    }

    private String formatDateToString(ForecastWeatherDto weatherDto) {
        Date date = new Date(weatherDto.getDate()*1000);
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MM-yyyy");

        return formattedDate.format(date);
    }
}
