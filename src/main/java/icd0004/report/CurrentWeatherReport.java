package icd0004.report;

import lombok.Data;

@Data
public class CurrentWeatherReport {
    private String date;
    private Double temperature;
    private int pressure;
    private int humidity;
}
