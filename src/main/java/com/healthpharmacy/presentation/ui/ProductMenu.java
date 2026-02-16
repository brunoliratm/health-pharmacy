package com.healthpharmacy.presentation.ui;

import com.healthpharmacy.application.dto.request.ProductRequestDTO;
import com.healthpharmacy.domain.constant.ProductCategory;
import com.healthpharmacy.domain.port.service.ProductUseCase;
import com.healthpharmacy.presentation.ui.util.ConsoleUtils;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductMenu {

  private final ProductUseCase productService;
  private final Scanner scanner;

  public ProductMenu(ProductUseCase productService, Scanner scanner) {
    this.scanner = scanner;
    this.productService = productService;
  }

  public void display() {
    while (true) {
      ConsoleUtils.clear();
      System.out.println("--- Product Management ---\n");
      System.out.println("[1] Register new product");
      System.out.println("[2] List catalog");
      System.out.println("[3] Find by Id");
      System.out.println("[4] Update product");
      System.out.println("[5] Remove product");
      System.out.println("[0] Return to main menu\n");
      System.out.print("Option: ");

      String option = scanner.nextLine();

      if (option.equals("0"))
        return;
      ConsoleUtils.clear();
      try {
        switch (option) {
          case "1" -> handleRegister();
          case "2" -> handleListAll();
          case "3" -> handleFindById();
          case "4" -> handleUpdate();
          case "5" -> handleRemove();
          default -> {
            System.out.println("Invalid Option, Try Again.");
            ConsoleUtils.handleDelay();
          }
        }
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
      ConsoleUtils.pressEnterToContinue();
    }
  }

  private void handleRegister() {
    System.out.println("> Register a new product <\n");
    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Description: ");
    String description = scanner.nextLine();

    BigDecimal price = readPrice("Price (e.g., 29.90): ");
    ProductCategory category = readCategory("Category: ");

    var request = new ProductRequestDTO(name, description, price, category);
    productService.create(request);
    System.out.println("\nProduct registered successfully!");
  }

  private void handleListAll() {
    ConsoleUtils.clear();
    System.out.println("> Product Catalog <\n");
    var products = productService.findAll();

    if (products.isEmpty()) {
      System.out.println("The catalog is currently empty.");
    } else {
      System.out.printf("%-5s | %-20s | %-12s | %-10s%n", "ID", "Name", "Category", "Price");
      System.out.println("-".repeat(55));
      products.forEach(p -> System.out.printf("%-5d | %-20s | %-12s | R$ %.2f%n",
          p.id(), p.name(), p.category(), p.price()));
    }
  }

  private void handleFindById() {
    System.out.println("> Find product by Id <\n");
    Long id = readLong("Enter Product ID: ");
    productService.findById(id).ifPresentOrElse(
        p -> System.out.printf("\nFound: [%s] %s - R$ %.2f\nDescription: %s%n",
            p.category(), p.name(), p.price(), p.description()),
        () -> System.out.println("\nProduct not found."));
  }

  private void handleUpdate() {
    System.out.println("> Update product <\n");
    Long id = readLong("Enter the ID of the product to update: ");

    System.out.println("\n(Press ENTER to skip a field and keep the current value)");

    System.out.print("New Name: ");
    String name = scanner.nextLine();
    name = name.isBlank() ? null : name;

    System.out.print("New Description: ");
    String description = scanner.nextLine();
    description = description.isBlank() ? null : description;

    BigDecimal price = readPriceOptional("New Price: ");
    ProductCategory category = readCategoryOptional("New Category: ");

    var request = new ProductRequestDTO(name, description, price, category);
    productService.update(id, request);
    System.out.println("\nProduct updated successfully!");
  }

  private void handleRemove() {
    System.out.println("> Remove product <\n");
    Long id = readLong("Enter ID to REMOVE: ");
    System.out.print("Are you sure? (Y/N): ");
    if (scanner.nextLine().equalsIgnoreCase("Y")) {
      productService.remove(id);
      System.out.println("\nProduct removed.");
    }
  }

  private Long readLong(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Long.parseLong(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a numeric ID.");
      }
    }
  }

  private BigDecimal readPrice(String message) {
    while (true) {
      try {
        System.out.print(message);
        return new BigDecimal(scanner.nextLine().replace(",", "."));
      } catch (Exception e) {
        System.out.println("Invalid price format! Use numbers (e.g., 10.50).");
      }
    }
  }

  private BigDecimal readPriceOptional(String message) {
    while (true) {
      System.out.print(message);
      String input = scanner.nextLine().replace(",", ".");
      if (input.isBlank())
        return null;
      try {
        return new BigDecimal(input);
      } catch (Exception e) {
        System.out.println("Invalid price format! Type a number or press ENTER to skip.");
      }
    }
  }

  private ProductCategory readCategory(String message) {
    while (true) {
      System.out.println("Categories: MEDICATIONS, COSMETICS, HYGIENE, MEDICAL_DEVICES, SUPPLEMENTS_AND_VITAMINS");
      System.out.print(message);
      try {
        return ProductCategory.valueOf(scanner.nextLine().toUpperCase().trim());
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid category! Choose from the list above.");
      }
    }
  }

  private ProductCategory readCategoryOptional(String message) {
    while (true) {
      System.out.println("Categories: MEDICATIONS, COSMETICS, HYGIENE, MEDICAL_DEVICES, SUPPLEMENTS_AND_VITAMINS");
      System.out.print(message);
      String input = scanner.nextLine().toUpperCase().trim();
      if (input.isBlank())
        return null;
      try {
        return ProductCategory.valueOf(input);
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid category! Type a valid one or press ENTER to skip.");
      }
    }
  }
}
