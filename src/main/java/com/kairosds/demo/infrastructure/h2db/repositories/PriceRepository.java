package com.kairosds.demo.infrastructure.h2db.repositories;

import com.kairosds.demo.infrastructure.h2db.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

    @Query(value =
            "SELECT * " +
            "FROM prices " +
            "WHERE " +
            "   ((:brandId IS NULL) OR (brandId = :brandId)) OR " +
            "   ((:productId IS NULL) OR (productId = :productId)) OR " +
            "   ((:applicationDate IS NULL) OR ((startDate >= :applicationDate) AND (endDate <= :applicationDate))",
            nativeQuery = true)
    List<PriceEntity> findByBrandIdOrProductIdOrApplicationDate(
            @Param("brandId") Integer brandId,
            @Param("productId") Integer productId,
            @Param("applicationDate") LocalDateTime applicationDate);
}
