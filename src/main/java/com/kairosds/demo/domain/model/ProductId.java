package com.kairosds.demo.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductId {

    private final Long value;

}
