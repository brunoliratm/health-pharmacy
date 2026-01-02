package com.healthpharmacy.domain.ports.repositories;

import com.healthpharmacy.domain.entities.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void add(Customer customer);
    Optional<Customer> findByCpf(String cpf);
    void update(String cpf, Customer customer); //parcial
    void delete(String cpf);
    List<Customer> findAll();
}
