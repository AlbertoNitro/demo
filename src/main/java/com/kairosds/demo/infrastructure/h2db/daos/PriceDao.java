package com.kairosds.demo.infrastructure.h2db.daos;

import com.kairosds.demo.infrastructure.h2db.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDao extends JpaRepository<PriceEntity, Integer> {

    List<PriceEntity> findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(
            Integer brandId,
            Integer productId,
            LocalDateTime startDate,
            LocalDateTime endDate);
}
