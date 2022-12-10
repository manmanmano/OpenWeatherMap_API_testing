package icd0004.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WeatherFileWriter {
    private static final Logger logger = LogManager.getLogger(WeatherFileWriter.class);
    public static File writeJsonToFile(String json, String city) throws IOException {
        File weatherFile = new File(city.toLowerCase() + ".json");
        if(weatherFile.exists()){
            logger.info("File "+ city + ".json already exists. Overwriting.");
        }
        Files.write(weatherFile.toPath(), json.getBytes());
        System.out.println("Weather information written to " + weatherFile.toPath());
        return weatherFile;
    }
}
