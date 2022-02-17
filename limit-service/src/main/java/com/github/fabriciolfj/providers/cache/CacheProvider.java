package com.github.fabriciolfj.providers.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fabriciolfj.business.usecase.SetLimitCache;
import com.github.fabriciolfj.entity.LimitAccountEntity;
import io.quarkus.redis.client.RedisClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CacheProvider implements SetLimitCache {

    private final RedisClient redisClient;
    private final ObjectMapper objectMapper;

    @Override
    public void addLimitToCache(LimitAccountEntity limit) {
        try {
            redisClient.set(Arrays.asList(limit.getAccount(), objectMapper.writeValueAsString(limit)));
        } catch (JsonProcessingException e) {
            log.error("Fail converter object to json, details: {}", e.getMessage());
        }
    }
}
