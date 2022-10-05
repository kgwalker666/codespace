package com.kgwalker.config;

import com.kgwalker.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

// @Configuration
public class C01Config {
    // 1. 自定义redisTemplate
    public static class ObjectRedisTemplate extends RedisTemplate<Object, Object> {
        public ObjectRedisTemplate(RedisConnectionFactory factory) {
            this.setKeySerializer(new StringRedisSerializer());
            this.setValueSerializer(new GenericJackson2JsonRedisSerializer());
            this.setHashKeySerializer(new StringRedisSerializer());
            this.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
            this.setConnectionFactory(factory);
        }
    }

    // 2. 交给容器管理；注意名字要是redisTemplate，覆盖掉默认的redisTemplate（否则可能一不小心注入错误。。。）
    // @Bean
    // public ObjectRedisTemplate redisTemplate(RedisConnectionFactory factory) {
    //     return new ObjectRedisTemplate(factory);
    // }

    // 1. 自定义redisTemplate
    public static class PersonRedisTemplate<T> extends RedisTemplate<String, T> {
        public PersonRedisTemplate(RedisConnectionFactory factory, Class<T> clazz) {
            this.setKeySerializer(new StringRedisSerializer());
            this.setValueSerializer(new Jackson2JsonRedisSerializer<>(clazz));
            this.setHashKeySerializer(new StringRedisSerializer());
            this.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(clazz));
            this.setConnectionFactory(factory);
        }
    }

    // 2. 交给容器管理；注意名字要是redisTemplate，覆盖掉默认的redisTemplate（否则可能一不小心注入错误。。。）
    @Bean
    public PersonRedisTemplate<Person> redisTemplate(RedisConnectionFactory factory) {
        return new PersonRedisTemplate<>(factory, Person.class);
    }
}
