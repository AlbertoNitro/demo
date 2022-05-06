package com.kairosds.demo.domain.persistence;

import com.kairosds.demo.domain.model.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricePersistence {

    List<Price> findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByStartDateDesc(Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate);

}
