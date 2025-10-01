package com.learn.weather_api.utils.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RestApiClient {
    private final RestClient restClient;

    public RestApiClient(RestClient restClient){
        this.restClient = restClient;
    }

    public <T> T get(String url, Class<T> responseType){
        System.out.println("url: " + url);
        return restClient.get().uri(url).retrieve().body(responseType);
    }

}
