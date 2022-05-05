package com.kariosds.demo.domain.persistence;

import com.kariosds.demo.domain.model.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricePersistence {

    List<Price> findByBrandIdOrProductIdOrStartDateGreatherThanEqualAndEndDateLessThanEqualNullSafe(Integer brandId, Integer productId, LocalDateTime applicationDate, LocalDateTime applicationDate);
}
