package com.healthpharmacy.domain.port.service;

import com.healthpharmacy.application.dto.request.CheckoutRequestDTO;
import com.healthpharmacy.application.dto.response.OrderResponseDTO;

import java.util.List;

public interface OrderUseCase {
    void checkout(CheckoutRequestDTO request);
    List<OrderResponseDTO> listHistoryByCustomer(String cpf);
    List<OrderResponseDTO> listAllOrders();
}
