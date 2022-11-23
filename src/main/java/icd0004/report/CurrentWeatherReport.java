package icd0004.report;

import lombok.Data;

@Data
public class CurrentWeatherReport {
    private String date;
    private Double temperature;
    private int humidity;
    private int pressure;
}
