package com.kariosds.demo.infrastructure.h2db.repositories;

import com.kariosds.demo.infrastructure.h2db.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

    List<PriceEntity> findByBrandIdOrProductIdOrStartDateGreatherThanEqualAndEndDateLessThanEqualNullSafe(Integer brandId, Integer productId, LocalDateTime applicationDate);
}
