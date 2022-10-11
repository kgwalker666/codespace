package com.kgwalker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class A02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A02.class);
        System.out.println(context.getBean(Test.class).getMyUser());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private String username;
        private String password;
    }

    @Bean
    public User user01() {
        return new User("张三", "123456");
    }

    @Bean
    public User user02() {
        return new User("李四", "1234");
    }

    @Bean
    public User user03() {
        return new User("王五", "111");
    }

    @Data
    @Configuration
    public static class Test {
        @Qualifier("user03")
        @Autowired(required = false)
        @SuppressWarnings("all")
        private User myUser;
    }
}
