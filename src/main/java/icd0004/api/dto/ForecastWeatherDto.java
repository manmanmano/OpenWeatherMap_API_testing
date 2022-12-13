package icd0004.api.dto;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastWeatherDto {
    @JsonProperty("dt")
    private long date;
    private MainDto main;
}
