package icd0004.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import icd0004.api.dto.CurrentWeatherDto;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import static com.sun.jersey.api.client.Client.create;
import static com.sun.jersey.api.json.JSONConfiguration.FEATURE_POJO_MAPPING;

public class WeatherApi {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";
    private static final String API_KEY = "f5fed9c8b74174a5c021904ade8402a5";

    public CurrentWeatherDto getCurrentWeatherData(String cityName) {
        String resourceUrl = BASE_URL + "/weather";

        ClientConfig configuration = new DefaultClientConfig();
        configuration.getClasses().add(JacksonJaxbJsonProvider.class);
        configuration.getFeatures().put(FEATURE_POJO_MAPPING, true);
        Client client = create(configuration);

        ClientResponse response = client.resource(resourceUrl)
                .queryParam("q", cityName)
                .queryParam("appid", API_KEY)
                .queryParam("units", "metric")
                .get(ClientResponse.class);
        return response.getEntity(CurrentWeatherDto.class);
    }
}
