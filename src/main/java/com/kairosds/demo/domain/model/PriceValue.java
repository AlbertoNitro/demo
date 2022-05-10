package com.kairosds.demo.domain.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class PriceValue {

    private final BigDecimal value;

}
