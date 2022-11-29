package icd0004.integration;

import icd0004.Main;
import icd0004.handler.WeatherHandler;
import icd0004.report.Weather;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherWriteTests {
    @Test
    public void givenListOfCitiesAsFile_mainWritesWeatherToFile(@TempDir Path tempDir) throws IOException {
        Path cities = tempDir.resolve("cities.txt");
        List<String> cityList = Arrays.asList("Tallinn", "Helsinki");
        WeatherHandler weatherHandler = new WeatherHandler();
        List<Weather> weatherReports = new ArrayList<>();
        for (String city:
             cityList) {
            weatherReports.add(weatherHandler.getWeather(city));
        }
        for (Weather weather : weatherReports) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(weather);
            File weatherFile = Main.writeJsonToFile(json);
            assertThat(weatherFile.getName()).isEqualTo(weather.getMainDetails().getCity().toLowerCase() + ".txt");
        }
    }
}
