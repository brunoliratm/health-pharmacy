package com.healthpharmacy.infrastructure.repositories;

import com.healthpharmacy.domain.entities.Product;
import com.healthpharmacy.domain.ports.repositories.ProductRepository;
import com.healthpharmacy.infrastructure.exceptions.PersistenceException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager entityManager;

    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error adding product:  " + product.getName());
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = entityManager.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public void update(Long id, Product product) {
        try {
            entityManager.getTransaction().begin();
            Product existing = entityManager.find(Product.class, id);
            if (existing != null) {
                if (product.getName() != null) existing.setName(product.getName());
                if (product.getPrice() != null) existing.setPrice(product.getPrice());
                if (product.getCategory() != null) existing.setCategory(product.getCategory());
                entityManager.merge(existing);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error updating product:  " + product.getName());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            if (product != null) {
                product.setActive(false);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error deleting product:  " + id);
        }
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
}
