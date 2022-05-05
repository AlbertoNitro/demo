package com.kairosds.demo.infrastructure.h2db.persistence;

import com.kairosds.demo.domain.model.Price;
import com.kairosds.demo.domain.persistence.PricePersistence;
import com.kairosds.demo.infrastructure.h2db.entities.PriceEntity;
import com.kairosds.demo.infrastructure.h2db.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PricePersistenceH2db implements PricePersistence {

    private final PriceRepository priceRepository;

    @Autowired
    public PricePersistenceH2db(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> findByBrandIdOrProductIdOrApplicationDate(Integer brandId, Integer productId) {
        LocalDateTime applicationDate = LocalDateTime.now();
        return priceRepository
                .findByBrandIdOrProductIdOrApplicationDate(brandId, productId, applicationDate)
                .stream()
                .map(PriceEntity::toPrice)
                .collect(Collectors.toList());
    }
}
