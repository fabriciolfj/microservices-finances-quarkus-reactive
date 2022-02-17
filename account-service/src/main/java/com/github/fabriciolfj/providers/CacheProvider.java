package com.github.fabriciolfj.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fabriciolfj.business.FindCache;
import com.github.fabriciolfj.business.UpdateCache;
import com.github.fabriciolfj.entities.LimitAccountEntity;
import com.github.fabriciolfj.exceptions.ExtractException;
import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class CacheProvider implements FindCache, UpdateCache {

    private final ObjectMapper objectMapper;
    private final ReactiveRedisClient redisClient;

    @Override
    public Uni<LimitAccountEntity> getCache(final String account) {
        return Uni.createFrom().item(account)
                .flatMap(c -> redisClient.get(account))
                .onItem().transform(result -> toEntity(result.toString()));
    }

    @Override
    public Uni<LimitAccountEntity> update(final LimitAccountEntity limitAccountEntity) {
        return redisClient.set(Arrays.asList(limitAccountEntity.getAccount(), toJson(limitAccountEntity)))
                .onItem().transform(v -> limitAccountEntity);
    }

    private String toJson(final LimitAccountEntity limitAccountEntity) {
        try {
            return objectMapper.writeValueAsString(limitAccountEntity);
        } catch (JsonProcessingException e) {
            throw new ExtractException(e.getMessage());
        }
    }

    private LimitAccountEntity toEntity(final String string) {
        try {
            var value =  objectMapper.readValue(string, LimitAccountEntity.class);
            log.info("Find limit: {}", value);
            return value;
        } catch (JsonProcessingException e) {
            throw new ExtractException(e.getMessage());

        }
    }
}
