package com.kariosds.demo.infrastructure.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kariosds.demo.domain.model.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
    private Integer productId;

    private Integer brandId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private BigDecimal price;

    public PriceDto(Price price) {
        this.productId = price.getProductId();
        this.brandId = price.getBrandId();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.price = price.getPrice();
    }
}
