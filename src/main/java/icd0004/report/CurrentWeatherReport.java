package icd0004.report;

import lombok.Data;

@Data
public class CurrentWeatherReport {
    private String date;
    private int temperature;
    private int humidity;
    private int pressure;
}
