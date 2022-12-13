package icd0004.api.dto;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponseListDto {
    @JsonProperty("list")
    private ArrayList<ForecastWeatherDto> forecasts;
}
