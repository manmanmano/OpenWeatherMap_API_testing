package icd0004.handler;

import icd0004.api.WeatherApi;
import icd0004.report.Weather;

public class WeatherHandler {
    private final WeatherApi weatherApi;
    public WeatherHandler() {
        weatherApi = new WeatherApi();
    }
    public WeatherHandler(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }
    public Weather getWeather(String city){
        Weather weather = new Weather();
        MainDetailsHandler mainDetailsHandler = new MainDetailsHandler(weatherApi);
        CurrentWeatherHandler currentWeatherHandler = new CurrentWeatherHandler(weatherApi);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApi);
        weather.setCurrentWeatherReport(currentWeatherHandler.getCurrentWeatherReport(city));
        weather.setMainDetails(mainDetailsHandler.getMainDetails(city));
        weather.setForecastWeatherReport(forecastWeatherHandler.getForecastWeatherReport(city));
        return weather;
    }

}
