package icd0004;

import icd0004.handler.WeatherHandler;
import icd0004.report.Weather;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String city = args[0];
        WeatherHandler weatherHandler = new WeatherHandler();
        Weather weather = weatherHandler.getWeather(city);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(weather);
        System.out.println(json);
    }
}