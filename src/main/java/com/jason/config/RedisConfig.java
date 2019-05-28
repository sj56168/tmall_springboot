package com.jason.config;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;


/**
 * Created by 我不管我最帅 on 2019/2/26.
 */
/*
@Configuration
@EnableCaching

public class RedisConfig extends JCacheConfigurerSupport {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    */
/*//*
/缓存管理器
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //第一种：
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                  .entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
        return RedisCacheManager
                  .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                  .cacheDefaults(redisCacheConfiguration).build();
        //第二种：
        //RedisCacheManager cacheManager =RedisCacheManager.create(redisTemplate);
        //  return cacheManager;
    }
*//*

    */
/**
     * RedisTemplate配置
     *
     * @param factory
     * @return
     *//*


    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {

        StringRedisTemplate template = new StringRedisTemplate(factory);

        //定义key序列化方式

        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型会出现异常信息;需要我们上面的自定义key生成策略，一般没必要

        //定义value的序列化方式

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();

        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(om);
        //key序列化
        template.setKeySerializer(redisSerializer);
        template.setHashKeySerializer(redisSerializer);
        //value 序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;

    }


}
*/


