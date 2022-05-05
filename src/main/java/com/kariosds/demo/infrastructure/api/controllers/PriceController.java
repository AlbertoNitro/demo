package com.kariosds.demo.infrastructure.api.controllers;

import com.kariosds.demo.domain.services.PriceService;
import com.kariosds.demo.infrastructure.api.dtos.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(PriceController.PRICES)
public class PriceController {
    public static final String PRICES = "/prices";
    public static final String SEARCH = "/search";
    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(SEARCH)
    public List<PriceDto> findByBrandIdOrProductIdOrStartDateGreatherThanEqualAndEndDateLessThanEqualNullSafe(
            @RequestParam(required = false) Integer brandId,
            @RequestParam(required = false) Integer productId) {
        return this.priceService.findByBrandIdOrProductIdOrStartDateGreatherThanEqualAndEndDateLessThanEqualNullSafe(
                brandId, productId).stream().map(PriceDto::new).collect(Collectors.toList());
    }

}
