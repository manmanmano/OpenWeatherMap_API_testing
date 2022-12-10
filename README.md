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
the project root folder containing either one or many existing city names.

For nonexistent cities the output will be null.

