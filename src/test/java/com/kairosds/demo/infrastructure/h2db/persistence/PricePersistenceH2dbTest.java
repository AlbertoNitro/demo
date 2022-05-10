package com.kairosds.demo.infrastructure.h2db.persistence;

import com.kairosds.demo.TestConfig;
import com.kairosds.demo.domain.model.Price;
import com.kairosds.demo.domain.services.SeederDBService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
@Slf4j
class PricePersistenceH2dbTest {

    @Autowired
    PricePersistenceH2db pricePersistenceH2db;

    @Autowired
    SeederDBService seederDBService;

    private final long BRAND_ID_DEFAULT = 1L;
    private final long PRODUCT_ID_DEFAULT = 35455L;

    @BeforeEach
    void setUp() {
        seederDBService.setUp();
    }

    @AfterEach
    void tearDown() {
        seederDBService.tearDown();
    }

    @Test
    void findByBrandIdAndProductIdTest() {
        List<Price> prices = pricePersistenceH2db.findByBrandIdAndProductId(BRAND_ID_DEFAULT, PRODUCT_ID_DEFAULT);
        prices.stream().forEach(priceEntity -> log.info(priceEntity.toString()));
        int countPrices = prices.size();
        log.info("countPrices = " + countPrices);
        final int NUM_TOTAL_PRICES = 4;
        assertTrue(countPrices >= NUM_TOTAL_PRICES);
    }
}