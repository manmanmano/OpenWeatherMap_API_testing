package icd0004.handler;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WeatherFileReader {
    public static List<String> getCities(String absolutePath) throws IOException {
        if(!absolutePath.substring(absolutePath.lastIndexOf(".") + 1).equals("txt")){
            return List.of();
        }
        Path filePath = Paths.get(absolutePath);
        if(!Files.exists(filePath)){
            return List.of();
        }
        return Files.readAllLines(filePath, Charset.defaultCharset());
    }
}
