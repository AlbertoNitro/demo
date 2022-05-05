package com.kariosds.demo.domain.services;

import com.kariosds.demo.domain.model.Price;
import com.kariosds.demo.domain.persistence.PricePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {

    private final PricePersistence pricePersistence;

    @Autowired
    public PriceService(PricePersistence pricePersistence) {
        this.pricePersistence = pricePersistence;
    }

    public List<Price> findByBrandIdOrProductIdOrStartDateGreatherThanEqualAndEndDateLessThanEqualNullSafe(Integer brandId, Integer productId) {
        LocalDateTime applicationDate = LocalDateTime.now();
        return pricePersistence.findByBrandIdOrProductIdOrStartDateGreatherThanEqualAndEndDateLessThanEqualNullSafe(brandId, productId, applicationDate);
    }
}
