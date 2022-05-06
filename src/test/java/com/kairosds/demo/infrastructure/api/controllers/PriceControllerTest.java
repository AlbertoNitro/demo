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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
@Slf4j
public class PriceControllerTest {

    @Autowired
    PriceController priceController;

    @Autowired
    SeederDBService seederDBService;

    private final int BRAND_ID_DEFAULT = 1;
    private final int PRODUCT_ID_DEFAULT = 35455;

    @BeforeEach
    void setUp() {
        seederDBService.setUp();
    }

    @AfterEach
    void tearDown() {
        seederDBService.tearDown();
    }

    @Test
    void findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDescDay14Hour10Test() {
        verifyFindFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(LocalDateTime.of(2020, 6, 14, 10, 0, 0),
                seederDBService.getPriceEntityWithPrice3550());
    }

    @Test
    void findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDescDay14Hour16Test() {
        verifyFindFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(LocalDateTime.of(2020, 6, 14, 16, 0, 0),
                seederDBService.getPriceEntityWithPrice2545());
    }

    @Test
    void findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDescDay14Hour21Test() {
        verifyFindFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(LocalDateTime.of(2020, 6, 14, 21, 0, 0),
                seederDBService.getPriceEntityWithPrice3550());
    }

    @Test
    void findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDescDay15Hour10Test() {
        verifyFindFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(LocalDateTime.of(2020, 6, 15, 10, 0, 0),
                seederDBService.getPriceEntityWithPrice3050());
    }

    @Test
    void findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDescDay15Hour21Test() {
        verifyFindFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(LocalDateTime.of(2020, 6, 15, 21, 0, 0),
                seederDBService.getPriceEntityWithPrice3895());
    }

    private void verifyFindFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(LocalDateTime applicationDate, PriceEntity priceEntity) {
        log.info("applicationDate = " + applicationDate.toString());
        List<PriceDto> priceDtoList = this.priceController.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(BRAND_ID_DEFAULT, PRODUCT_ID_DEFAULT, applicationDate);
        log.info(priceDtoList.toString());
        assertEquals(new PriceDto(priceEntity.toPrice()), priceDtoList.get(0));
    }
}
