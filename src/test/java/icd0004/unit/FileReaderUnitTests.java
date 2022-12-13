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
    @Test
    public void whenFileDoesNotExist_ReturnsEmptyList(@TempDir Path tempDir) throws IOException {
        Path cities = tempDir.resolve("cities.txt");
        assertThat(WeatherFileReader.getCities(cities.toString())).isEqualTo(List.of());
    }
    @Test
    public void whenFileIsEmpty_ReturnsEmptyList(@TempDir Path tempDir) throws IOException {
        Path cities = tempDir.resolve("cities.txt");
        cities.toFile().createNewFile();
        assertThat(WeatherFileReader.getCities(cities.toString())).isEqualTo(List.of());
    }
    @Test
    public void whenFileHasWrongExtension_returnEmptyList(@TempDir Path tempDir) throws IOException {
        Path cities = tempDir.resolve("cities.md");
        assertThat(WeatherFileReader.getCities(cities.toString())).isEqualTo(List.of());
    }
}
