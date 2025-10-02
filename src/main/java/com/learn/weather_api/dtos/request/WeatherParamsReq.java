package com.learn.weather_api.dtos.request;

import com.learn.weather_api.errors.ApiErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherParamsReq {
    @NotNull(message = "location " + ApiErrorMessages.VALUE_REQUIRED)
    @NotBlank(message = "location " + ApiErrorMessages.VALUE_NOT_BLANK)
    private String location;
    @NotNull(message = "from " + ApiErrorMessages.VALUE_REQUIRED)
    private LocalDate from;
    @NotNull(message = "to " + ApiErrorMessages.VALUE_REQUIRED)
    private LocalDate to;

    public List<String> getPropertyList(){
        List<String> propertyList = new ArrayList<>();
        propertyList.add(this.location);
        propertyList.add(this.from.format(DateTimeFormatter.ISO_LOCAL_DATE));
        propertyList.add(this.to.format(DateTimeFormatter.ISO_LOCAL_DATE));

        return propertyList;
    }
}
