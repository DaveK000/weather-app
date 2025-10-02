package com.learn.weather_api.controllers;

import com.learn.weather_api.dtos.request.WeatherParamsReq;
import com.learn.weather_api.dtos.request.WeatherReq;
import com.learn.weather_api.service.WeatherService;
import com.learn.weather_api.utils.api.ParamsBuilder;
import com.learn.weather_api.valueobjects.WeatherData;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherResource {

    private WeatherService weatherService;
    private ParamsBuilder paramsBuilder;

    public WeatherResource(WeatherService weatherService, ParamsBuilder paramsBuilder){
        this.weatherService = weatherService;
        this.paramsBuilder = paramsBuilder;
    }

    @PostMapping("/simpleWeatherData")
    public ResponseEntity<WeatherData> getSimpleWeatherData(@Valid @RequestBody WeatherReq weatherReq){
        WeatherData weatherData = weatherService
                .getWeatherData(weatherReq.getLocation());
        return ResponseEntity.ok(weatherData);
    }

    @PostMapping("/weatherData")
    public ResponseEntity<WeatherData> getWeatherData(@Valid @RequestBody WeatherParamsReq weatherParamsReq) {
        String params = paramsBuilder.buildParams(weatherParamsReq.getPropertyList());
        WeatherData weatherData = weatherService
                .getWeatherData(params);
        return ResponseEntity.ok(weatherData);
    }
}
