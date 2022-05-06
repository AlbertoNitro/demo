package com.kairosds.demo.domain.services;

import com.kairosds.demo.domain.model.Price;
import com.kairosds.demo.domain.persistence.PricePersistence;
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

    public List<Price> findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate) {
        return pricePersistence.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(brandId, productId, startDate, endDate);
    }
}
