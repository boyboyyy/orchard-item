//package com.orchard.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//@Slf4j
//
//public class RedisConfiguration {
//    //加入@Bean为的是，让其项目启动，交由容器管理
//    @Bean
//    public RedisTemplate redisTemplate (RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate redisTemplate = new RedisTemplate<>();
//        //设置redis的连接工厂对象
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        //设置redis Key的序列化其
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        return  redisTemplate;
//    }
//}
