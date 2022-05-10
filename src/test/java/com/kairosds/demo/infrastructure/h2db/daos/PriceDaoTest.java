package com.kairosds.demo.infrastructure.h2db.daos;

import com.kairosds.demo.TestConfig;
import com.kairosds.demo.domain.services.SeederDBService;
import com.kairosds.demo.infrastructure.h2db.entities.PriceEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
@Slf4j
class PriceDaoTest {

    private final long BRAND_ID_DEFAULT = 1L;
    private final long PRODUCT_ID_DEFAULT = 35455L;

    @Autowired
    PriceDao priceDao;

    @Autowired
    SeederDBService seederDBService;

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
        List<PriceEntity> priceEntities = priceDao.findByBrandIdAndProductId(BRAND_ID_DEFAULT, PRODUCT_ID_DEFAULT);
        priceEntities.stream().forEach(priceEntity -> log.info(priceEntity.toString()));
        int countPriceEntities = priceEntities.size();
        log.info("countPriceEntities = " + countPriceEntities);
        final int NUM_TOTAL_PRICES = 4;
        assertTrue(countPriceEntities >= NUM_TOTAL_PRICES);
    }
}