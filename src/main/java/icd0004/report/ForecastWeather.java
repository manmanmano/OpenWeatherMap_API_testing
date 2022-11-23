package icd0004.report;

import lombok.Data;

@Data
public class ForecastWeather {
    private Double temperature;
    private int pressure;
    private int humidity;
}
