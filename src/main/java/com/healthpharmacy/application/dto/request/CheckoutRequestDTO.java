package com.healthpharmacy.application.dto.request;

import com.healthpharmacy.domain.constant.PaymentMethod;
import java.util.List;

public record CheckoutRequestDTO(
    String customerCpf,
    List<Long> productIds,
    PaymentMethod paymentMethod,
    String password) {
}
