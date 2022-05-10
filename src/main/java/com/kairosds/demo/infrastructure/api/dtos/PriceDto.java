package com.kairosds.demo.infrastructure.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kairosds.demo.domain.model.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
    private Long productId;

    private Long brandId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private BigDecimal priceValue;

    public PriceDto(Price priceValue) {
        this.productId = priceValue.getProductId().getValue();
        this.brandId = priceValue.getBrandId().getValue();
        this.startDate = priceValue.getStartDate();
        this.endDate = priceValue.getEndDate();
        this.priceValue = priceValue.getPriceValue().getValue();
    }
}
