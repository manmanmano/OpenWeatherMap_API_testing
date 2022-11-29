package icd0004;

import icd0004.handler.WeatherHandler;
import icd0004.report.Weather;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        String city = args[0];
        WeatherHandler weatherHandler = new WeatherHandler();
        Weather weather = weatherHandler.getWeather(city);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(weather);
        System.out.println(json);
    }
    public static File writeJsonToFile(String json, String city) throws IOException {
        File weatherFile = new File(city.toLowerCase() + ".json");
        Files.write(weatherFile.toPath(), json.getBytes());

        return weatherFile;
    }
}