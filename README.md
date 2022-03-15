# Spring Boot with Redis: HashOperations CRUD Functionality

See [Spring Boot with Redis: HashOperations CRUD Functionality](https://stackabuse.com/spring-boot-with-redis-hashoperations-crud-functionality/)

## Test Demo Application Interaction with Redis (Installed Locally)

* Installe Redis locally (Ubuntu):
https://www.digitalocean.com/community/tutorials/how-to-install-and-secure-redis-on-ubuntu-18-04

* RedisInsight: Redis GUI - Get Started
https://docs.redis.com/latest/ri/installing/install-redis-desktop/

```
chmod +x redisinsight-linux64-<version>
```

* Start RedisInsight (Redis GUI)

```
./redisinsight-linux64-<version>
```

To access your RedisInsight GUI, open a web browser and navigate to http://127.0.0.1:8001

* Run RedisSpringBootDemoApplication or UserRepositoryTest in debug mode

- Observe each action (create, update, delete) in Redis GUI or redis-cli