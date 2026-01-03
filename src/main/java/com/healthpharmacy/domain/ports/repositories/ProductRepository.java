package com.healthpharmacy.domain.ports.repositories;

import com.healthpharmacy.domain.entities.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void add(Product product);
    Optional<Product> findById(Long id);
    void update(Long id, Product product);
    void delete(Long id);
    List<Product> findAll();
}
