package com.example.redisspringbootdemo;

import com.example.redisspringbootdemo.model.User;
import com.example.redisspringbootdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class RedisSpringBootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RedisSpringBootDemoApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);
        log.info("User repository: {}", userRepository);

        userRepository.create(new User("1", "username", "user@mail.com"));
        User user = userRepository.get("1");

        user.setName("username2");
        userRepository.update(user);

        userRepository.delete(user.getUserId());
    }

}
