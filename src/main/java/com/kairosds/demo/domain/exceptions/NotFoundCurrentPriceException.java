package com.kairosds.demo.domain.exceptions;

import java.time.LocalDateTime;

public class NotFoundCurrentPriceException extends NotFoundException {

    public NotFoundCurrentPriceException(long brandId, long productId, LocalDateTime applicationDate) {
        super("Non existent a current price for brandId(" + brandId + "), productId(" + productId + ") and applicationDate(" + applicationDate + ")");
    }

}
