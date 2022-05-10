package com.kairosds.demo.domain.persistence;

import com.kairosds.demo.domain.model.Price;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricePersistence {

    List<Price> findByBrandIdAndProductId(long brandId, long productId);

}
