package icd0004.integration;

import icd0004.handler.WeatherFileReader;
import icd0004.handler.WeatherFileWriter;
import icd0004.handler.WeatherHandler;
import icd0004.report.Weather;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherWriteTests {
    @Test
    public void givenListOfCities_WritesWeatherToFile() throws IOException {
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
            File weatherFile = WeatherFileWriter.writeJsonToFile(json, weather.getMainDetails().getCity());
            assertThat(weatherFile.getName()).isEqualTo(weather.getMainDetails().getCity().toLowerCase() + ".json");
        }
    }
    @Test
    public void givenFileOfCities_writesWeatherToFiles(@TempDir Path tempDir) throws IOException {
        Path cities = tempDir.resolve("cities.txt");
        List<String> cityList = Arrays.asList("Tallinn", "Helsinki");
        Files.write(cities, cityList);

        List<String> cityListOut = WeatherFileReader.getCities(cities.toString());
        WeatherHandler weatherHandler = new WeatherHandler();
        List<Weather> weatherReports = new ArrayList<>();
        for (String city : cityListOut) {
            weatherReports.add(weatherHandler.getWeather(city));
        }
        for (Weather weather : weatherReports) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(weather);
            File weatherFile = WeatherFileWriter.writeJsonToFile(json, weather.getMainDetails().getCity());
            assertThat(weatherFile.getName()).isEqualTo(weather.getMainDetails().getCity().toLowerCase() + ".json");
        }
    }
    @Test
    public void givenFileOfCity_writesWeatherToFile(@TempDir Path tempDir) throws IOException {
        Path cities = tempDir.resolve("cities.txt");
        List<String> cityList = List.of("Buffalo");
        Files.write(cities, cityList);

        List<String> cityListOut = WeatherFileReader.getCities(cities.toString());
        WeatherHandler weatherHandler = new WeatherHandler();
        List<Weather> weatherReports = new ArrayList<>();
        for (String city : cityListOut) {
            weatherReports.add(weatherHandler.getWeather(city));
        }
        for (Weather weather : weatherReports) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(weather);
            File weatherFile = WeatherFileWriter.writeJsonToFile(json, weather.getMainDetails().getCity());
            assertThat(weatherFile.getName()).isEqualTo(weather.getMainDetails().getCity().toLowerCase() + ".json");
        }
    }
    @Test
    public void givenFileWithInvalidCities_writesOnlyValidCityWeather(@TempDir Path tempDir) throws IOException {
        Path cities = tempDir.resolve("cities.txt");
        List<String> cityList = List.of("Buffalo", "kekek");
        Files.write(cities, cityList);

        List<String> cityListOut = WeatherFileReader.getCities(cities.toString());
        WeatherHandler weatherHandler = new WeatherHandler();
        List<Weather> weatherReports = new ArrayList<>();
        for (String city : cityListOut) {
            weatherReports.add(weatherHandler.getWeather(city));
        }
        weatherReports.remove(null);
        assertThat(weatherReports.size()).isEqualTo(1);
        for (Weather weather : weatherReports) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(weather);
            File weatherFile = WeatherFileWriter.writeJsonToFile(json, weather.getMainDetails().getCity());
            assertThat(weatherFile.getName()).isEqualTo(weather.getMainDetails().getCity().toLowerCase() + ".json");
        }
    }
}
