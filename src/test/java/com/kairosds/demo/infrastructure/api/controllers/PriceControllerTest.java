package com.kairosds.demo.infrastructure.api.controllers;

import com.kairosds.demo.TestConfig;
import com.kairosds.demo.domain.services.SeederDBService;
import com.kairosds.demo.infrastructure.api.dtos.PriceDto;
import com.kairosds.demo.infrastructure.h2db.entities.PriceEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
@Slf4j
public class PriceControllerTest {

    private final long BRAND_ID_DEFAULT = 1L;
    private final long PRODUCT_ID_DEFAULT = 35455L;

    @Autowired
    PriceController priceController;

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
    void findCurrentPriceDay14Hour10Test() {
        verifyFindCurrentPrice(LocalDateTime.of(2020, 6, 14, 10, 0, 0), seederDBService.getPriceEntityWithPrice3550());
    }

    @Test
    void findCurrentPriceDay14Hour16Test() {
        verifyFindCurrentPrice(LocalDateTime.of(2020, 6, 14, 16, 0, 0), seederDBService.getPriceEntityWithPrice2545());
    }

    @Test
    void findCurrentPriceDay14Hour21Test() {
        verifyFindCurrentPrice(LocalDateTime.of(2020, 6, 14, 21, 0, 0), seederDBService.getPriceEntityWithPrice3550());
    }

    @Test
    void findCurrentPriceDay15Hour10Test() {
        verifyFindCurrentPrice(LocalDateTime.of(2020, 6, 15, 10, 0, 0), seederDBService.getPriceEntityWithPrice3050());
    }

    @Test
    void findCurrentPriceDay15Hour21Test() {
        verifyFindCurrentPrice(LocalDateTime.of(2020, 6, 15, 21, 0, 0), seederDBService.getPriceEntityWithPrice3895());
    }

    private void verifyFindCurrentPrice(LocalDateTime applicationDate, PriceEntity priceEntityExpected) {
        log.info("applicationDate = " + applicationDate.toString());
        PriceDto priceDto = priceController.findCurrentPrice(BRAND_ID_DEFAULT, PRODUCT_ID_DEFAULT, applicationDate);
        log.info("priceDto = " + priceDto.toString());
        assertEquals(new PriceDto(priceEntityExpected.toPrice()), priceDto);
    }
}
