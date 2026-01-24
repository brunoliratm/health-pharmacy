package com.healthpharmacy.application.service;

import com.healthpharmacy.application.dto.request.CustomerRequestDTO;
import com.healthpharmacy.application.dto.request.CustomerUpdateRequestDTO;
import com.healthpharmacy.application.dto.response.CustomerResponseDTO;
import com.healthpharmacy.domain.entity.Customer;
import com.healthpharmacy.domain.port.service.CustomerUseCase;
import com.healthpharmacy.domain.port.repository.CustomerRepository;
import com.healthpharmacy.infrastructure.exception.AlreadyExistsException;
import com.healthpharmacy.infrastructure.exception.EntityNotFoundException;
import com.healthpharmacy.infrastructure.exception.ValidationException;
import java.util.List;
import java.util.Optional;

public class CustomerService implements CustomerUseCase {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void register(CustomerRequestDTO request) {
    if (!isCpfValid(request.cpf()))
      throw new ValidationException("Invalid CPF: " + request.cpf());
    if (customerRepository.findByCpf(request.cpf()).isPresent())
      throw new AlreadyExistsException("Customer with CPF " + request.cpf() + " already exists");

    Customer customer = new Customer(
        request.cpf(),
        request.name(),
        request.email(),
        request.password(),
        request.birthDate());
    customerRepository.add(customer);
  }

  @Override
  public void update(String cpf, CustomerUpdateRequestDTO request) {
    if (customerRepository.findByCpf(cpf).isEmpty())
      throw new EntityNotFoundException("Customer with CPF " + cpf + " not found");

    Customer updated = new Customer();
    if (request.name() != null)
      updated.setName(request.name());
    if (request.email() != null)
      updated.setEmail(request.email());
    if (request.birthDate() != null)
      updated.setBirthDate(request.birthDate());
    if (request.password() != null)
      updated.setPassword(request.password());

    customerRepository.update(cpf, updated);
  }

  @Override
  public void delete(String cpf) {
    if (customerRepository.findByCpf(cpf).isEmpty())
      throw new EntityNotFoundException("Customer with CPF " + cpf + " not found");
    customerRepository.delete(cpf);
  }

  @Override
  public Optional<CustomerResponseDTO> findByCpf(String cpf) {
    return customerRepository.findByCpf(cpf).map(this::mapToResponse);
  }

  @Override
  public List<CustomerResponseDTO> listAll() {
    return customerRepository.findAll().stream().map(this::mapToResponse).toList();
  }

  private boolean isCpfValid(String cpf) {
    return cpf != null && cpf.length() == 11 && cpf.matches("\\d+");
  }

  private CustomerResponseDTO mapToResponse(Customer customer) {
    return new CustomerResponseDTO(
        customer.getCpf(),
        customer.getName(),
        customer.getEmail(),
        customer.getAge());
  }
}
