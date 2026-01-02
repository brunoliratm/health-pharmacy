package com.healthpharmacy.domain.ports.repositories;

import com.healthpharmacy.domain.entities.FinalizedOrder;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<FinalizedOrder> findAll();
    Optional<FinalizedOrder> findById(Long id);
    List<FinalizedOrder> findByCustomerCpf(String cpf);
    void save(FinalizedOrder order);
}
