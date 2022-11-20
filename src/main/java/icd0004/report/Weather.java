package icd0004.report;

import lombok.Data;

@Data
public class Weather {
    private MainDetails mainDetails;
    private CurrentWeatherReport currentWeatherReport;
}
