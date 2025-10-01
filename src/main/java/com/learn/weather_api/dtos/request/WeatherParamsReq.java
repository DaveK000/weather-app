package com.learn.weather_api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherParamsReq {
    private String location;
    private LocalDate from;
    private LocalDate to;

    public List<String> getPropertyList(){
        List<String> propertyList = new ArrayList<>();
        propertyList.add(this.location);
        propertyList.add(this.from.format(DateTimeFormatter.ISO_LOCAL_DATE));
        propertyList.add(this.to.format(DateTimeFormatter.ISO_LOCAL_DATE));

        return propertyList;
    }
}
