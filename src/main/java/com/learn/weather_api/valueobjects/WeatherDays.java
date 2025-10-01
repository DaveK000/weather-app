package com.learn.weather_api.valueobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDays {
    private LocalDate datetime;
    private float tempmax;
    private float tempmin;
    private float temp;
}
