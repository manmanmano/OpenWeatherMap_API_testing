# icd0004-courseproject "OpenWeatherMap query"

## Technological stack
Console app using on Java 17. Built on Gradle 7.6. See `build.gradle` for a full list of dependencies.

## Developers
Mariano D'Angelo 201752IVSB

Mihkel Kiil 201748IVSB
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

## Distributions
After building the application, binaries can be found in `build/distribtuions` in TAR or ZIP format. 
To run a distribtution, use the applicable launch script for your OS in the `bin` directory of the distribution.
````
./icd0004-courseproject Helsinki
````

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
