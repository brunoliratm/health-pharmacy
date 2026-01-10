package com.healthpharmacy.application.dto.response;

import com.healthpharmacy.domain.constant.ProductCategory;
import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        ProductCategory category
) {
}
