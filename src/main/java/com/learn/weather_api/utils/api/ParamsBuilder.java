package com.learn.weather_api.utils.api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParamsBuilder {

    public String buildParams(List<String> params) {
        return String.join("/",params);
    }
}
