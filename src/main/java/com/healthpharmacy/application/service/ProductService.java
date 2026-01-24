package com.healthpharmacy.application.service;

import com.healthpharmacy.application.dto.request.ProductRequestDTO;
import com.healthpharmacy.application.dto.response.ProductResponseDTO;
import com.healthpharmacy.domain.entity.Product;
import com.healthpharmacy.domain.port.repository.ProductRepository;
import com.healthpharmacy.domain.port.service.ProductUseCase;
import com.healthpharmacy.infrastructure.exception.EntityNotFoundException;
import com.healthpharmacy.infrastructure.exception.ValidationException;
import java.util.List;
import java.util.Optional;

public class ProductService implements ProductUseCase {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void create(ProductRequestDTO request) {
    if (request.price().doubleValue() <= 0)
      throw new ValidationException("The price of the product must be greater than zero");

    Product product = new Product(
        null,
        request.name(),
        request.description(),
        request.category(),
        request.price());

    productRepository.add(product);
  }

  @Override
  public void update(Long id, ProductRequestDTO request) {
    if (productRepository.findById(id).isEmpty())
      throw new EntityNotFoundException("Product with Id " + id + "not found");

    Product updated = new Product();
    if (request.name() != null)
      updated.setName(request.name());
    if (request.category() != null)
      updated.setCategory(request.category());
    if (request.description() != null)
      updated.setDescription(request.description());
    if (request.price() != null)
      updated.setPrice(request.price());

    productRepository.update(id, updated);
  }

  @Override
  public void remove(Long id) {
    if (productRepository.findById(id).isEmpty()) {
      throw new EntityNotFoundException("Product with Id " + id + " not found");
    }
    productRepository.delete(id);
  }

  @Override
  public Optional<ProductResponseDTO> findById(Long id) {
    return productRepository.findById(id).map(this::mapToResponse);
  }

  @Override
  public List<ProductResponseDTO> findAll() {
    return productRepository.findAll().stream().map(this::mapToResponse).toList();
  }

  private ProductResponseDTO mapToResponse(Product product) {
    return new ProductResponseDTO(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getCategory());
  }
}
