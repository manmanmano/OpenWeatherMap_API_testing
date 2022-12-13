package icd0004.handler;

import icd0004.api.WeatherApi;
import icd0004.report.Weather;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class WeatherHandler {
    private final WeatherApi weatherApi;

    public WeatherHandler() {
        weatherApi = new WeatherApi();
    }

    public WeatherHandler(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }
    private static final Logger logger = LogManager.getLogger(WeatherHandler.class);

    public Weather getWeather(String city){
        Weather weather = new Weather();
        MainDetailsHandler mainDetailsHandler = new MainDetailsHandler(weatherApi);
        CurrentWeatherHandler currentWeatherHandler = new CurrentWeatherHandler(weatherApi);
        ForecastWeatherHandler forecastWeatherHandler = new ForecastWeatherHandler(weatherApi);

        if (currentWeatherHandler.getCurrentWeatherReport(city) == null){
            logger.error("City '" + city + "' not found.");

            return null;
        }

        weather.setCurrentWeatherReport(currentWeatherHandler.getCurrentWeatherReport(city));
        weather.setMainDetails(mainDetailsHandler.getMainDetails(city));
        weather.setForecastWeatherReport(forecastWeatherHandler.getForecastWeatherReport(city));

        return weather;
    }
}
