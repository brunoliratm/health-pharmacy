package com.healthpharmacy.domain.port.repository;

import com.healthpharmacy.domain.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void add(Customer customer);
    Optional<Customer> findByCpf(String cpf);
    void update(String cpf, Customer customer);
    void delete(String cpf);
    List<Customer> findAll();
}
