package com.example.redisspringbootdemo.repository;

import com.example.redisspringbootdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@Repository
public class UserRepository {

    private HashOperations hashOperations;

    @Autowired
    public UserRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void create(User user) {
        hashOperations.put("USER", user.getUserId(), user);
        log.info("User with ID {} saved", user.getUserId());
    }

    public User get(String userId) {
        User user = (User) hashOperations.get("USER", userId);
        log.info("Retrieved user with ID {}: {}", userId, user);
        return user;
    }

    public Map<String, User> getAll(){
        Map<String, User> entries = hashOperations.entries("USER");
        log.info("Retrieved all User entries: {}", entries);
        return entries;
    }

    public void update(User user) {
        hashOperations.put("USER", user.getUserId(), user);
        log.info("User with ID {} updated", user.getUserId());
    }

    public void delete(String... userIds) {
        hashOperations.delete("USER", userIds);
        log.info("Users with IDs ({}) deleted", Arrays.asList(userIds));
    }
}
