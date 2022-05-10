package com.kairosds.demo.domain.services;

import com.kairosds.demo.TestConfig;
import com.kairosds.demo.domain.exceptions.NotFoundCurrentPriceException;
import com.kairosds.demo.domain.model.Price;
import com.kairosds.demo.domain.persistence.PricePersistence;
import com.kairosds.demo.infrastructure.h2db.entities.PriceEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestConfig
@Slf4j
class PriceServiceTest {

    private final long BRAND_ID_DEFAULT = 1L;
    private final long PRODUCT_ID_DEFAULT = 35455L;

    @Autowired
    PriceService priceService;

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
    void finCurrentPriceDay15Hour21Test() {
        verifyFindCurrentPrice(LocalDateTime.of(2020, 6, 15, 21, 0, 0), seederDBService.getPriceEntityWithPrice3895());
    }

    @Test
    void findCurrentPriceDayThrowNotFoundCurrentPriceException() {
        PricePersistence pricePersistence = mock(PricePersistence.class);
        when(pricePersistence.findByBrandIdAndProductId(anyLong(), anyLong())).thenReturn(Collections.emptyList());
        PriceService priceServiceMock = new PriceService(pricePersistence);
        NotFoundCurrentPriceException notFoundCurrentPriceException = assertThrows(NotFoundCurrentPriceException.class, () -> {
            priceServiceMock.findCurrentPrice(BRAND_ID_DEFAULT, PRODUCT_ID_DEFAULT, LocalDateTime.of(2020, 6, 15, 10, 0, 0));
        });
        log.info(notFoundCurrentPriceException.toString());
    }

    private void verifyFindCurrentPrice(LocalDateTime applicationDate, PriceEntity priceEntityExpected) {
        log.info("applicationDate = " + applicationDate.toString());
        Price price = priceService.findCurrentPrice(BRAND_ID_DEFAULT, PRODUCT_ID_DEFAULT, applicationDate);
        log.info("price = " + price.toString());
        assertEquals(priceEntityExpected.toPrice(), price);
    }
}