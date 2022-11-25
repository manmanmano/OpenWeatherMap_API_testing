package icd0004.api.dto;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherDto {
    @JsonProperty("name")
    private String city;
    private MainDto main;
    @JsonProperty("coord")
    private CoordinatesDto coordinates;
    @JsonProperty("dt")
    private long date;
}
