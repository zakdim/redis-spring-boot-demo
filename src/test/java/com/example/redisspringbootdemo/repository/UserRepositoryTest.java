package com.example.redisspringbootdemo.repository;

import com.example.redisspringbootdemo.configuration.RedisConfiguration;
import com.example.redisspringbootdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisConfiguration.class, UserRepository.class, User.class})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRepository() {
        User user1 = new User("1", "user1", "user1@mail.com");
        User user2 = new User("2", "user2", "user2@mail.com");

        // create
        userRepository.create(user1);
        User createdUser1 = userRepository.get(user1.getUserId());
        assertEquals(user1.getName(), createdUser1.getName());

        userRepository.create(user2);
        User createdUser2 = userRepository.get(user2.getUserId());
        assertEquals(user2.getName(), createdUser2.getName());

        // getAll
        Map<String, User> users =  userRepository.getAll();
        log.info("Users retrieved: {}", users);
        assertTrue(users.size() == 2);

        // update
        createdUser2.setName("user2.1");
        createdUser2.setEmail("user2.1@mail.com");
        userRepository.update(createdUser2);
        User updatedUser2 = userRepository.get(createdUser2.getUserId());
        assertEquals(createdUser2.getName(), updatedUser2.getName());
        assertEquals(createdUser2.getEmail(), updatedUser2.getEmail());

        // delete
        userRepository.delete(createdUser1.getUserId(), createdUser2.getUserId());
        users = userRepository.getAll();
        assertTrue(users.size() == 0);
    }
}