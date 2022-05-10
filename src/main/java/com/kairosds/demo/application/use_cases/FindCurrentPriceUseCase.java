package com.kairosds.demo.application.use_cases;

import com.kairosds.demo.domain.model.Price;

import java.time.LocalDateTime;

public interface FindCurrentPriceUseCase {

    Price findCurrentPrice(long brandId, long productId, LocalDateTime applicationDate);

}
