package com.kairosds.demo.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Currency {

    private final String value;

}
