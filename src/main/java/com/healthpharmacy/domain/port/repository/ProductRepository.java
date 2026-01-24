package com.healthpharmacy.domain.port.repository;

import com.healthpharmacy.domain.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void add(Product product);
    Optional<Product> findById(Long id);
    void update(Long id, Product product);
    void delete(Long id);
    List<Product> findAll();
}
