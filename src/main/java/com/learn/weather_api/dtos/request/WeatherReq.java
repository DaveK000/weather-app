package com.learn.weather_api.dtos.request;

import com.learn.weather_api.errors.ApiErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherReq {
    @NotNull(message = "location " + ApiErrorMessages.VALUE_REQUIRED)
    @NotBlank(message = "location " + ApiErrorMessages.VALUE_NOT_BLANK)
    private String location;
}
