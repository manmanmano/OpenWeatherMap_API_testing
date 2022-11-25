package icd0004.report;

import lombok.Data;

@Data
public class ForecastWeatherReport {
    private String date;
    private ForecastWeather weather;
}
