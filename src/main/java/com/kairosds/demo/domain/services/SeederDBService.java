package com.kairosds.demo.domain.services;

import com.kairosds.demo.infrastructure.h2db.daos.PriceDao;
import com.kairosds.demo.infrastructure.h2db.entities.PriceEntity;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class SeederDBService {

    @Autowired
    private PriceDao priceDao;
    @Getter
    private PriceEntity priceEntityWithPrice3550;
    @Getter
    private PriceEntity priceEntityWithPrice2545;
    @Getter
    private PriceEntity priceEntityWithPrice3050;
    @Getter
    private PriceEntity priceEntityWithPrice3895;

    public void setUp() {
        priceEntityWithPrice3550 = PriceEntity
                .builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(new BigDecimal("35.50"))
                .currency("EUR")
                .build();
        priceEntityWithPrice2545 = PriceEntity
                .builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
                .priceList(2)
                .productId(35455)
                .priority(1)
                .price(new BigDecimal("25.45"))
                .currency("EUR")
                .build();
        priceEntityWithPrice3050 = PriceEntity
                .builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
                .priceList(3)
                .productId(35455)
                .priority(1)
                .price(new BigDecimal("30.50"))
                .currency("EUR")
                .build();
        priceEntityWithPrice3895 = PriceEntity
                .builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .priceList(4)
                .productId(35455)
                .priority(1)
                .price(new BigDecimal("38.95"))
                .currency("EUR")
                .build();
        priceDao.saveAll(Arrays.asList(priceEntityWithPrice3550, priceEntityWithPrice2545, priceEntityWithPrice3050, priceEntityWithPrice3895));
    }

    public void tearDown() {
        priceDao.deleteAll();
    }

}
