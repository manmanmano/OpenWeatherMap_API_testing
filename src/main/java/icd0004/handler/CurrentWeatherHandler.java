package icd0004.handler;

import icd0004.api.WeatherApi;

public class CurrentWeatherHandler {

    private final WeatherApi weatherApi;

    public CurrentWeatherHandler() {
        this.weatherApi = new WeatherApi();
    }

    public CurrentWeatherHandler(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }
}
