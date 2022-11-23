package icd0004.report;

import lombok.Data;

@Data
public class ForecastWeather {
    private Double temperature;
    private int humidity;
    private int pressure;
}
