package com.healthpharmacy.infrastructure.repository;

import com.healthpharmacy.domain.entity.FinalizedOrder;
import com.healthpharmacy.domain.entity.Product;
import com.healthpharmacy.domain.port.repository.OrderRepository;
import com.healthpharmacy.infrastructure.exception.PersistenceException;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private final EntityManager entityManager;

    public OrderRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<FinalizedOrder> findAll() {
        return entityManager.createQuery("SELECT p FROM FinalizedOrder p", FinalizedOrder.class).getResultList();
    }

    @Override
    public Optional<FinalizedOrder> findById(Long id) {
        return Optional.ofNullable(entityManager.find(FinalizedOrder.class, id));
    }

    @Override
    public List<FinalizedOrder> findByCustomerCpf(String cpf) {
        return entityManager.createQuery("SELECT o FROM FinalizedOrder o WHERE o.customer.cpf =: cpf", FinalizedOrder.class).setParameter("cpf", cpf).getResultList();
    }

    @Override
    public void save(FinalizedOrder order) {
        try {
            entityManager.getTransaction().begin();

            List<Product> managedProducts = new ArrayList<>();
            for (Product p : order.getProducts()) {
                managedProducts.add(entityManager.merge(p));
            }
            order.setProducts(managedProducts);

            entityManager.persist(order);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            throw new PersistenceException("Error processing order: id " + order.getId());
        }
    }
}
