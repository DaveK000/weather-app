package com.learn.weather_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.weather_api.utils.api.RestApiClient;
import com.learn.weather_api.valueobjects.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private RestApiClient restApiClient;
    private RedisManager redisManager;
    private ObjectMapper mapper;

    @Value("${api.weather.url}")
    private String apiUrl;

    @Value("${api.weather.key}")
    private String apiKey;

    public WeatherService(
            RestApiClient restApiClient,
            RedisManager redisManager,
            ObjectMapper mapper){
        this.restApiClient = restApiClient;
        this.redisManager = redisManager;
        this.mapper = mapper;
    }

    public WeatherData getWeatherData(String params, String location){
        String weatherFromRedis = redisManager.getValue(location);

        if (weatherFromRedis == null){
            WeatherData weatherData = restApiClient.get(
                    apiUrl + params + "?key=" + apiKey,
                    WeatherData.class);
            redisManager.setValue(location, weatherData);
            return weatherData;
        }

        try {
            return mapper.readValue(weatherFromRedis, WeatherData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to parse json from redis",e);
        }

    }

}
