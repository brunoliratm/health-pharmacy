package com.healthpharmacy.application.service;

import com.healthpharmacy.application.dto.request.CheckoutRequestDTO;
import com.healthpharmacy.application.dto.response.CustomerResponseDTO;
import com.healthpharmacy.application.dto.response.OrderResponseDTO;
import com.healthpharmacy.application.dto.response.ProductResponseDTO;
import com.healthpharmacy.domain.entity.Customer;
import com.healthpharmacy.domain.entity.FinalizedOrder;
import com.healthpharmacy.domain.entity.Product;
import com.healthpharmacy.domain.port.repository.OrderRepository;
import com.healthpharmacy.domain.port.service.CustomerUseCase;
import com.healthpharmacy.domain.port.service.OrderUseCase;
import com.healthpharmacy.domain.port.service.ProductUseCase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

public class OrderService implements OrderUseCase {

  private final OrderRepository orderRepository;
  private final CustomerUseCase customerService;
  private final ProductUseCase productService;

  public OrderService(OrderRepository orderRepository, CustomerUseCase customerService, ProductUseCase productService) {
    this.orderRepository = orderRepository;
    this.customerService = customerService;
    this.productService = productService;
  }

  @Override
  public void checkout(CheckoutRequestDTO request) {
    CustomerResponseDTO customerResponseDTO = customerService.findByCpf(request.customerCpf())
        .orElseThrow(() -> new EntityNotFoundException("Customer not found with CPF: " + request.customerCpf()));

    List<Product> products = new ArrayList<>();
    BigDecimal total = BigDecimal.ZERO;

    for (Long productId : request.productIds()) {
      ProductResponseDTO productResponseDTO = productService.findById(productId)
          .orElseThrow(() -> new EntityNotFoundException("Product not found with Id:" + productId));

      products.add(mapProductDtoToEntity(productResponseDTO));
      total = total.add(productResponseDTO.price());
    }

    Customer customer = new Customer();
    customer.setCpf(customerResponseDTO.cpf());
    customer.setName(customerResponseDTO.name());

    FinalizedOrder order = new FinalizedOrder(
        products,
        customer,
        total,
        request.paymentMethod());
    orderRepository.save(order);
  }

  @Override
  public List<OrderResponseDTO> listHistoryByCustomer(String cpf) {
    return orderRepository.findByCustomerCpf(cpf).stream()
        .map(this::mapToResponse)
        .collect(Collectors.toList());
  }

  @Override
  public List<OrderResponseDTO> listAllOrders() {
    return orderRepository.findAll().stream()
        .map(this::mapToResponse)
        .collect(Collectors.toList());
  }

  private OrderResponseDTO mapToResponse(FinalizedOrder order) {
    List<String> productNames = order.getProducts().stream()
        .map(Product::getName)
        .collect(Collectors.toList());

    return new OrderResponseDTO(
        order.getId(),
        order.getOrderDate(),
        order.getCustomer().getName(),
        productNames,
        order.getTotalAmount(),
        order.getPaymentMethod());
  }

  private Product mapProductDtoToEntity(ProductResponseDTO dto) {
    return new Product(
        dto.id(),
        dto.name(),
        dto.description(),
        dto.category(),
        dto.price());
  }
}
