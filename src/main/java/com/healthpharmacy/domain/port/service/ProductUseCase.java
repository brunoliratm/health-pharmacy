package com.healthpharmacy.domain.port.service;

import com.healthpharmacy.application.dto.request.ProductRequestDTO;
import com.healthpharmacy.application.dto.response.ProductResponseDTO;
import java.util.List;
import java.util.Optional;

public interface ProductUseCase {
    void create(ProductRequestDTO request);
    void update(Long id, ProductRequestDTO request);
    void remove(Long id);
    Optional<ProductResponseDTO> findById(Long id);
    List<ProductResponseDTO> findAll();
}
