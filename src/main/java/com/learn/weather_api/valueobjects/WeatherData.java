package com.learn.weather_api.valueobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private float latitude;
    private float longitude;
    private String resolvedAddress;
    private List<WeatherDays> days;
}
