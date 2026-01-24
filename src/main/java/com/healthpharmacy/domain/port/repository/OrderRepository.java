package com.healthpharmacy.domain.port.repository;

import com.healthpharmacy.domain.entity.FinalizedOrder;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<FinalizedOrder> findAll();
    Optional<FinalizedOrder> findById(Long id);
    List<FinalizedOrder> findByCustomerCpf(String cpf);
    void save(FinalizedOrder order);
}
