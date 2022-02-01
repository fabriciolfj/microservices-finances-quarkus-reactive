package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.LimitAccountEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindLimitTest {

    private FindLimit findLimit;

    @BeforeEach
    public void setup() {
        this.findLimit = new FindLimit();
    }

    @Test
    void testFindLimitPreimum() {
        final LimitAccountEntity limitAccountEntity = findLimit.execute(UUID.randomUUID().toString(), BigDecimal.valueOf(3000));

        assertTrue(limitAccountEntity.getRate().compareTo(BigDecimal.valueOf(0.9)) == 0);
        assertTrue(limitAccountEntity.getWithdrawalAmount().compareTo(20) == 0);
    }
}
