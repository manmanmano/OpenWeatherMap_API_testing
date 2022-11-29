package icd0004.unit;

import icd0004.handler.WeatherFileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileReaderUnitTests {
    @Test
    public void whenFileIsCorrect_ReturnListOfStrings(@TempDir Path tempDir) throws IOException {
        Path cities = tempDir.resolve("cities.txt");
        List<String> cityList = Arrays.asList("Tallinn", "Helsinki");
        Files.write(cities, cityList);

        assertThat(WeatherFileReader.getCities(cities.toString())).isEqualTo(cityList);
    }
}
