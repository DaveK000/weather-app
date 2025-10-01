package com.learn.weather_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.weather_api.dtos.request.WeatherReq;
import com.learn.weather_api.valueobjects.WeatherData;
import com.learn.weather_api.valueobjects.WeatherLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisManager {

    private RedisTemplate<String, String> template;
    private ObjectMapper mapper;

    public RedisManager(
            RedisTemplate<String, String> template,
            ObjectMapper mapper
    ){
        this.template = template;
        this.mapper = mapper;
    }

    public String getValue(String key) {
        Long expire = template.getExpire(key);
        System.out.println("EXPIRE: " + expire);
        return template.opsForValue().get(key);
    }


    public boolean setValue(String key, WeatherData weatherData){
        String value;
        try {
            value = mapper.writeValueAsString(weatherData);
        } catch (JsonProcessingException e){
            throw new RuntimeException("Unable to process object to json", e);
        }
        log.info(value);

        template.opsForValue().set(key,value);
        template.expire(key, 1, TimeUnit.MINUTES);
        return true;
    }

}
