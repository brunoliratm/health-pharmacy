package com.healthpharmacy.application.dto.response;

import com.healthpharmacy.domain.constant.PaymentMethod;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDTO(
        Long id,
        LocalDateTime orderDate,
        String customerName,
        List<String> productNames,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod
) {
}
