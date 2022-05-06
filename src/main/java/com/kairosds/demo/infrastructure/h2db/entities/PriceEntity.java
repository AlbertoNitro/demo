package com.kairosds.demo.infrastructure.h2db.entities;

import com.kairosds.demo.domain.model.Price;
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
    private Integer brandId;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;

    private Integer priceList;

    @NotNull
    private Integer productId;

    private Integer priority;

    @NotNull
    private BigDecimal price;

    @NotNull
    @NotBlank
    private String currency;

    public Price toPrice() {
        return Price
                .builder()
                .brandId(brandId)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(priceList)
                .productId(productId)
                .priority(priority)
                .price(price)
                .currency(currency)
                .build();
    }

}
