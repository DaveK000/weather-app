# Weather-app

This project is a learning project to explore and getting better at developing with Java.
It is an API to get weather for a selected location.
The API will check if the location is already cached in Redis and if not, it will fetch the data 
from [Visualcrossing API](https://www.visualcrossing.com) and then it will cache the results for 1 min.

[Project page on Roadmap.sh](https://roadmap.sh/projects/weather-api-wrapper-service)

## Getting started

This project can be launched using Docker Compose.

### Step 1: Clone the repository

### Step 2: Launch the app using Docker compose

1. Navigate to the root of the cloned repository.
2. Launch the following command to generate the jar file: 
````bash
mvn clean install -DskipTests
````

3. Run the following command to start the application in detached mode:

````bash
docker compose up -d
````

## How to use

Chose your favourite client, i use postman, to consume APIs:

### weatherDataSimple POST

It allows you to get weather data for the next 15 days using the location name

#### Endopoint:

http://localhost:8080/api/weather/weatherDataSimple

#### Request Body:
````json
{
  "location" : "London"
}
````

#### Response:

````json
{
  "latitude": 45.468,
  "longitude": 9.18179,
  "resolvedAddress": "Milano, Lombardia, Italia",
  "days": [
    {
      "datetime": [
        2025,
        10,
        2
      ],
      "tempmax": 64.1,
      "tempmin": 46.7,
      "temp": 56.7
    },
    {
      "datetime": [
        2025,
        10,
        3
      ],
      "tempmax": 62.0,
      "tempmin": 48.1,
      "temp": 54.7
    },
    {
      "datetime": [
        2025,
        10,
        4
      ],
      "tempmax": 64.5,
      "tempmin": 51.2,
      "temp": 57.3
    },
    {
      "datetime": [
        2025,
        10,
        5
      ],
      "tempmax": 66.5,
      "tempmin": 55.8,
      "temp": 60.3
    },
    {
      "datetime": [
        2025,
        10,
        6
      ],
      "tempmax": 66.5,
      "tempmin": 49.4,
      "temp": 57.9
    },
    {
      "datetime": [
        2025,
        10,
        7
      ],
      "tempmax": 69.5,
      "tempmin": 54.8,
      "temp": 61.5
    },
    {
      "datetime": [
        2025,
        10,
        8
      ],
      "tempmax": 70.4,
      "tempmin": 56.6,
      "temp": 63.0
    },
    {
      "datetime": [
        2025,
        10,
        9
      ],
      "tempmax": 71.0,
      "tempmin": 58.0,
      "temp": 64.1
    },
    {
      "datetime": [
        2025,
        10,
        10
      ],
      "tempmax": 71.3,
      "tempmin": 58.7,
      "temp": 64.7
    },
    {
      "datetime": [
        2025,
        10,
        11
      ],
      "tempmax": 71.5,
      "tempmin": 58.9,
      "temp": 64.9
    },
    {
      "datetime": [
        2025,
        10,
        12
      ],
      "tempmax": 71.3,
      "tempmin": 59.6,
      "temp": 65.0
    },
    {
      "datetime": [
        2025,
        10,
        13
      ],
      "tempmax": 70.2,
      "tempmin": 58.7,
      "temp": 64.4
    },
    {
      "datetime": [
        2025,
        10,
        14
      ],
      "tempmax": 65.0,
      "tempmin": 60.5,
      "temp": 62.5
    },
    {
      "datetime": [
        2025,
        10,
        15
      ],
      "tempmax": 64.1,
      "tempmin": 56.6,
      "temp": 60.3
    },
    {
      "datetime": [
        2025,
        10,
        16
      ],
      "tempmax": 62.7,
      "tempmin": 51.2,
      "temp": 56.9
    }
  ]
}
````

### weatherData POST

It allows you to get weather data for the specified date interval using the location name

#### Endopoint:

http://localhost:8080/api/weather/weatherData

#### Request Body:
````json
{
  "location": "London",
  "from" : "2025-10-02",
  "to" : "2025-10-05"

}
````

#### Response:

````json
{
  "latitude": 51.5072,
  "longitude": -0.1275,
  "resolvedAddress": "London",
  "days": [
    {
      "datetime": [
        2025,
        10,
        2
      ],
      "tempmax": 65.4,
      "tempmin": 50.4,
      "temp": 57.8
    },
    {
      "datetime": [
        2025,
        10,
        3
      ],
      "tempmax": 63.2,
      "tempmin": 56.0,
      "temp": 59.5
    },
    {
      "datetime": [
        2025,
        10,
        4
      ],
      "tempmax": 64.8,
      "tempmin": 51.7,
      "temp": 57.9
    },
    {
      "datetime": [
        2025,
        10,
        5
      ],
      "tempmax": 60.2,
      "tempmin": 48.3,
      "temp": 54.8
    }
  ]
}
````
