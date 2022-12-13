# icd0004-courseproject

## Technological stack

    - Java 17
    - Gradle 7.4

## Participants

    - Mariano D'Angelo 201752IVSB
    - Mihkel Kiil 201748IVSB

## CLI 

These commands are meant to be run on a Linux machine with gradle installed.

For Windows use ./gradlew.bat instead of ./gradlew

### Compile and build: 

    ./gradlew --build-cache assemble

### Run tests: 

    ./gradlew test

### Give input to the application and run it: 

    ./gradlew run --args="Tallinn"

    ./gradlew run --args="fileContainingCity.txt"

In the first case the argument can be any existing city name.

In the second case the argument is an existing file located in 
the project root folder containing either one or many existing city names. The file must use the extension `.txt`. The structure is as follows
```
London
Hamburg
Kyiv
```

For nonexistent cities no file will be written, and no data will be output to console.

## Example output

```
{
  "mainDetails" : {
    "city" : "Kharkiv",
    "coordinates" : "50.00,36.25",
    "temperatureUnit" : "Celsius"
  },
  "currentWeatherReport" : {
    "date" : "10-12-2022",
    "temperature" : 5,
    "humidity" : 95,
    "pressure" : 1013
  },
  "forecastWeatherReport" : [ {
    "date" : "11-12-2022",
    "weather" : {
      "temperature" : 9,
      "humidity" : 63,
      "pressure" : 1010
    }
  }, {
    "date" : "12-12-2022",
    "weather" : {
      "temperature" : 5,
      "humidity" : 75,
      "pressure" : 1010
    }
  }, {
    "date" : "13-12-2022",
    "weather" : {
      "temperature" : 3,
      "humidity" : 84,
      "pressure" : 1008
    }
  } ]
}
```
If the city is given as a CLI argument, the output is written to stdout. If the cities are given as a file, the output will be written to a `.json` file for each city.
