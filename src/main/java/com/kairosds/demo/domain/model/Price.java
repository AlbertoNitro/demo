package com.kairosds.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {

    @NonNull
    private BrandId brandId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull
    private LocalDateTime endDate;

    @NonNull
    private Integer priceList;

    @NonNull
    private ProductId productId;

    @NonNull
    private Priority priority;

    @NonNull
    private PriceValue priceValue;

    @NonNull
    private Currency currency;

}
