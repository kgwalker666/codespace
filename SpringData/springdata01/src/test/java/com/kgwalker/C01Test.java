package com.kgwalker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgwalker.config.C01Config;
import com.kgwalker.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Slf4j
@SpringBootTest
public class C01Test {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 将一个Person对象通过json序列化存储到redis中；然后读取出来转换成对象
    @Test
    void testStringRedisTemplate() throws JsonProcessingException {
        // 1. 创建Person对象
        Person person = new Person(1L, "张三", "男");

        // 2. 通过序列化工具转换成json字符串
        String personJson = new ObjectMapper().writeValueAsString(person);
        log.info(personJson);

        // 3. 写入redis
        // 3.1. 获取操作字符串值的操作器
        ValueOperations<String, String> operations = this.stringRedisTemplate.opsForValue();
        // 3.2. 写入redis
        operations.set("person01", personJson);

        // 4. 读取redis，获取person的json字符串
        String readPersonJson = operations.get("person01");
        log.info(readPersonJson);

        // 5. 转为person对象
        Person readPerson = new ObjectMapper().readValue(readPersonJson, Person.class);

        // 6. 展示person对象
        log.info(readPerson.toString());
    }

    // @Autowired
    private C01Config.ObjectRedisTemplate objectRedisTemplate;

    @Test
    void testObjectRedisTemplate() {
        // 1. 创建Person对象
        Person person = new Person(1L, "张三", "男");

        // 2. 写入redis
        // 2.1. 获取操作字符串值的操作器
        ValueOperations<Object, Object> operations = this.objectRedisTemplate.opsForValue();
        // 2.2. 写入redis
        operations.set("person02", person);

        // 3. 读取redis，获取person的json字符串
        Person readPerson = (Person) operations.get("person02");

        // 4. 展示person对象
        assert readPerson != null;
        log.info(readPerson.toString());
    }

    // @Autowired
    private C01Config.PersonRedisTemplate<Person> personRedisTemplate;

    @Test
    void testPersonRedisTemplate() {
        // 1. 创建Person对象
        Person person = new Person(1L, "张三", "男");

        // 2. 写入redis
        // 2.1. 获取操作字符串值的操作器
        ValueOperations<String, Person> operations = this.personRedisTemplate.opsForValue();
        // 2.2. 写入redis
        operations.set("person03", person);

        // 3. 读取redis，获取person的json字符串
        Person readPerson = operations.get("person03");

        // 4. 展示person对象
        assert readPerson != null;
        log.info(readPerson.toString());
    }

    // 测试自带的序列化器
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    void testRedisTemplate() {
        // 1. 创建Person对象
        Person person = new Person(1L, "张三", "男");

        // 2. 写入redis
        ValueOperations<Object, Object> operations = this.redisTemplate.opsForValue();
        operations.set("person04", person);

        // 3. 读取redis
        Person readPerson = (Person) operations.get("person04");

        // 4. 展示
        assert readPerson != null;
        log.info(readPerson.toString());
    }
}
