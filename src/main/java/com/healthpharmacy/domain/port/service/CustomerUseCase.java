package com.healthpharmacy.domain.port.service;

import com.healthpharmacy.application.dto.request.CustomerRequestDTO;
import com.healthpharmacy.application.dto.response.CustomerResponseDTO;
import java.util.List;
import java.util.Optional;

public interface CustomerUseCase {
    void register(CustomerRequestDTO request);
    void update(String cpf, CustomerRequestDTO request);
    void delete(String cpf);
    Optional<CustomerResponseDTO> findByCpf(String cpf);
    List<CustomerResponseDTO> listAll();
}
