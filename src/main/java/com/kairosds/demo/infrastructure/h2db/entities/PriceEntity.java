package com.kairosds.demo.infrastructure.h2db.entities;

import com.kairosds.demo.domain.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "prices")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long brandId;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;

    private Integer priceList;

    @NotNull
    private Long productId;

    private Integer priority;

    @NotNull
    private BigDecimal priceValue;

    @NotNull
    @NotBlank
    private String currency;

    public Price toPrice() {
        return Price
                .builder()
                .brandId(BrandId.builder().value(brandId).build())
                .startDate(startDate)
                .endDate(endDate)
                .priceList(priceList)
                .productId(ProductId.builder().value(productId).build())
                .priority(Priority.builder().value(priority).build())
                .priceValue(PriceValue.builder().value(priceValue).build())
                .currency(Currency.builder().value(currency).build())
                .build();
    }

}
