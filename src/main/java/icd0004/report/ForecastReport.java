package icd0004.report;

import lombok.Data;

@Data
public class ForecastReport {
    private String date;
    private ForecastWeather weather;
}
