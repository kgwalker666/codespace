package com.kgwalker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.function.BiConsumer;

@SpringBootApplication
public class C01Application {
    public static void main(String[] args) {
       SpringApplication.run(C01Application.class, args);
    }
}
