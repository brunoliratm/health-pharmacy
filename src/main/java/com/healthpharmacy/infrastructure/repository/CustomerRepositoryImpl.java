package com.healthpharmacy.infrastructure.repository;

import com.healthpharmacy.domain.entity.Customer;
import com.healthpharmacy.domain.port.repository.CustomerRepository;
import com.healthpharmacy.infrastructure.exception.PersistenceException;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error registering customer: " + customer.getName());
        }
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        return Optional.ofNullable(entityManager.find(Customer.class, cpf));
    }

    @Override
    public void update(String cpf, Customer customer) {
        try {
            entityManager.getTransaction().begin();
            Customer existing = entityManager.find(Customer.class, cpf);
            if (existing != null) {
                if (customer.getName() != null) existing.setName(customer.getName());
                if (customer.getEmail() != null) existing.setEmail(customer.getEmail());
                if (customer.getPassword() != null) existing.setPassword(customer.getPassword());
                if (customer.getBirthDate() != null) existing.setBirthDate(customer.getBirthDate());
                entityManager.merge(existing);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            throw new PersistenceException("Error Updating customer: " + customer.getName());
        }
    }

    @Override
    public void delete(String cpf) {
        try {
            entityManager.getTransaction().begin();
            Customer customer = entityManager.find(Customer.class, cpf);
            if  (customer != null) {
                customer.setActive(false);
                entityManager.merge(customer);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error removing customer: " + cpf);
        }
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("SELECT c FROM Customer c",Customer.class).getResultList();
    }
}
