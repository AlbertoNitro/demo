package com.kairosds.demo.domain.services;

import com.kairosds.demo.application.use_cases.FindCurrentPriceUseCase;
import com.kairosds.demo.domain.exceptions.NotFoundCurrentPriceException;
import com.kairosds.demo.domain.model.Price;
import com.kairosds.demo.domain.persistence.PricePersistence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PriceService implements FindCurrentPriceUseCase {

    private final PricePersistence pricePersistence;

    @Autowired
    public PriceService(PricePersistence pricePersistence) {
        this.pricePersistence = pricePersistence;
    }

    public Price findCurrentPrice(long brandId, long productId, LocalDateTime applicationDate) {
        List<Price> prices = pricePersistence.findByBrandIdAndProductId(brandId, productId);
        return prices
                .parallelStream()
                .filter(p -> p.getStartDate().isBefore(applicationDate) && p.getEndDate().isAfter(applicationDate))
                .sorted(Comparator.comparing(Price::getStartDate).reversed())
                .collect(Collectors.toList())
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundCurrentPriceException(brandId, productId, applicationDate));
    }
}
