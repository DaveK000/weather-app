package com.learn.weather_api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private int id;
    private String name;
}
