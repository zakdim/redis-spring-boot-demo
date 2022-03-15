package com.example.redisspringbootdemo.repository;

import com.example.redisspringbootdemo.configuration.RedisConfiguration;
import com.example.redisspringbootdemo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisConfiguration.class, UserRepository.class, User.class})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRepository() {

        userRepository.create(new User("1", "username", "createdUser@mail.com"));
        User createdUser = userRepository.get("1");
        assertEquals("username", createdUser.getName());

        createdUser.setName("username2");
        userRepository.update(createdUser);
        User updatedUser = userRepository.get("1");
        assertEquals("username2", updatedUser.getName());

        userRepository.delete(createdUser.getUserId());
    }
}