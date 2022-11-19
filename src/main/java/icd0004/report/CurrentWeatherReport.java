package icd0004.report;

import lombok.Data;

@Data
public class CurrentWeatherReport {
    private String city;
    private Double temperature;
}
