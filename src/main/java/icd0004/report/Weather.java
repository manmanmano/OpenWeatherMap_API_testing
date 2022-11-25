package icd0004.report;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Weather {
    private MainDetails mainDetails;
    private CurrentWeatherReport currentWeatherReport;
    private ArrayList<ForecastWeatherReport> forecastWeatherReport;
}
