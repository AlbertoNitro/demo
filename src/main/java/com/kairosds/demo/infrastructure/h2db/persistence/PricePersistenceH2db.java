package com.kairosds.demo.infrastructure.h2db.persistence;

import com.kairosds.demo.domain.model.Price;
import com.kairosds.demo.domain.persistence.PricePersistence;
import com.kairosds.demo.infrastructure.h2db.daos.PriceDao;
import com.kairosds.demo.infrastructure.h2db.entities.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PricePersistenceH2db implements PricePersistence {

    private final PriceDao priceDao;

    @Autowired
    public PricePersistenceH2db(PriceDao priceDao) {
        this.priceDao = priceDao;
    }

    @Override
    public List<Price> findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate) {
        return priceDao
                .findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(brandId, productId, startDate, endDate)
                .stream()
                .map(PriceEntity::toPrice)
                .collect(Collectors.toList());
    }
}
