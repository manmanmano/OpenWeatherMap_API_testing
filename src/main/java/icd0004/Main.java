package icd0004;

import icd0004.handler.WeatherFileReader;
import icd0004.handler.WeatherHandler;
import icd0004.report.Weather;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static icd0004.handler.WeatherFileWriter.writeJsonToFile;

public class Main {

    public static void main(String[] args) throws IOException {
        WeatherHandler weatherHandler = new WeatherHandler();
        if(args[0].substring(args[0].lastIndexOf(".") + 1).equals("txt")){
            if(!getWeatherFromFile(args[0], weatherHandler)){
                System.out.println("Error reading file! Either the extension is wrong or the file is empty or missing.");
            }
        }
        else {
            System.out.println(getWeatherFromString(args[0], weatherHandler));
        }
    }

    public static String getWeatherFromString(String city, WeatherHandler weatherHandler) throws IOException {
        Weather weather = weatherHandler.getWeather(city);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(weather);
    }

    public static boolean getWeatherFromFile(String filename, WeatherHandler weatherHandler) throws IOException {
        List<String> cities = WeatherFileReader.getCities(filename);
        if(cities.isEmpty()){
            return false;
        }
        List<Weather> weatherReports = new ArrayList<>();
        for (String s : cities) {
            weatherReports.add(weatherHandler.getWeather(s));
        }
        for (Weather weatherReport : weatherReports) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(weatherReport);
            writeJsonToFile(json, weatherReport.getMainDetails().getCity());
        }
        return true;
    }
}