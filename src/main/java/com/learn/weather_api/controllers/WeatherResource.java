package com.learn.weather_api.controllers;

import com.learn.weather_api.dtos.request.WeatherParamsReq;
import com.learn.weather_api.dtos.request.WeatherReq;
import com.learn.weather_api.dtos.response.WeatherConditionRes;
import com.learn.weather_api.service.WeatherService;
import com.learn.weather_api.utils.api.ParamsBuilder;
import com.learn.weather_api.valueobjects.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/weatherDataSimple")
    public ResponseEntity<WeatherData> getWeatherDataSimple(@RequestBody WeatherReq weatherReq){
        WeatherData weatherData = this.weatherService
                .getWeatherData(weatherReq.getLocation(), weatherReq.getLocation());
        return ResponseEntity.ok(weatherData);
    }

    @PostMapping("/weatherData")
    public ResponseEntity<WeatherData> getWeatherData(@RequestBody WeatherParamsReq weatherParamsReq){
        String params = paramsBuilder.buildParams(weatherParamsReq.getPropertyList());
        System.out.println("params: " + params);
        WeatherData weatherData = weatherService
                .getWeatherData(params,weatherParamsReq.getLocation());
        return ResponseEntity.ok(weatherData);
    }
}
