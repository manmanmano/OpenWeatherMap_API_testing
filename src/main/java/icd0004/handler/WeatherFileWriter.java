package icd0004.handler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WeatherFileWriter {
    public static File writeJsonToFile(String json, String city) throws IOException {
        File weatherFile = new File(city.toLowerCase() + ".json");
        Files.write(weatherFile.toPath(), json.getBytes());
        System.out.println("Weather information written to " + weatherFile.toPath());
        return weatherFile;
    }
}
