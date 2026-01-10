package com.healthpharmacy.application.dto.request;

import com.healthpharmacy.domain.constant.ProductCategory;
import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        String description,
        BigDecimal price,
        ProductCategory category
) {
}
