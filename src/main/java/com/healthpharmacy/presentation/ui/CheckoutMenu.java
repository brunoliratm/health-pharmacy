package com.healthpharmacy.presentation.ui;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.healthpharmacy.application.dto.request.CheckoutRequestDTO;
import com.healthpharmacy.application.dto.response.OrderResponseDTO;
import com.healthpharmacy.domain.constant.PaymentMethod;
import com.healthpharmacy.domain.port.service.OrderUseCase;
import com.healthpharmacy.presentation.ui.util.ConsoleUtils;

public class CheckoutMenu {
  private final OrderUseCase orderService;
  private final Scanner scanner;

  public CheckoutMenu(OrderUseCase orderService, Scanner scanner) {
    this.orderService = orderService;
    this.scanner = scanner;
  }

  public void display() {
    while (true) {
      ConsoleUtils.clear();
      System.out.println("--- CHECKOUT / SALES ---\n");
      System.out.println("[1] Start New Sale");
      System.out.println("[2] View Full Sales History");
      System.out.println("[3] View History by Customer (CPF)");
      System.out.println("[0] Back to Main Menu\n");
      System.out.print("Option: ");

      String option = scanner.nextLine();

      if (option.equals("0"))
        return;

      ConsoleUtils.clear();
      try {
        switch (option) {
          case "1" -> handleCheckout();
          case "2" -> handleListAllHistory();
          case "3" -> handleListHistoryByCustomer();
          default -> System.out.println("Invalid option, try again.");
        }
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
      ConsoleUtils.pressEnterToContinue();
    }
  }

  private void handleCheckout() {
    System.out.println("> New Sale <\n");

    System.out.print("Customer CPF: ");
    String cpf = scanner.nextLine();

    List<Long> productIds = new ArrayList<>();
    while (true) {
      Long id = readLong("Enter Product ID (or '0' to finish): ");
      if (id == 0)
        break;
      productIds.add(id);
    }

    if (productIds.isEmpty()) {
      System.out.println("Sale canceled: No products added.");
      return;
    }

    PaymentMethod payment = readPaymentMethod();

    System.out.print("Enter Customer Password: ");
    String password = scanner.nextLine();

    var request = new CheckoutRequestDTO(cpf, productIds, payment, password);
    orderService.checkout(request);

    System.out.println("\nSale Completed.");
  }

  private void handleListAllHistory() {
    System.out.println("> Full Sales History<\n");
    var orders = orderService.listAllOrders();
    printOrders(orders);
  }

  private void handleListHistoryByCustomer() {
    System.out.print("\nEnter Customer CPF: ");
    String cpf = scanner.nextLine();

    ConsoleUtils.clear();
    System.out.println("> Purchase History for: " + cpf + " <\n");
    var orders = orderService.listHistoryByCustomer(cpf);
    printOrders(orders);
  }

  private void printOrders(List<OrderResponseDTO> orders) {
    if (orders.isEmpty()) {
      System.out.println("No records found.");
    } else {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

      System.out.printf("%-4s | %-16s | %-12s | %-10s | %-15s%n",
          "ID", "Date", "Total", "Payment", "Customer");
      System.out.println("-".repeat(70));

      for (var o : orders) {
        System.out.printf("%-4d | %-16s | R$ %-8.2f | %-10s | %-15s%n",
            o.id(),
            o.orderDate().format(formatter),
            o.totalAmount(),
            o.paymentMethod(),
            o.customerName());
        System.out.println("     └─ Products: " + String.join(", ", o.productNames()));
      }
    }
  }

  private PaymentMethod readPaymentMethod() {
    while (true) {
      System.out.println("\nAvailable Payment Methods:");
      for (PaymentMethod method : PaymentMethod.values()) {
        System.out.println("- " + method);
      }
      System.out.print("Select method: ");
      try {
        return PaymentMethod.valueOf(scanner.nextLine().toUpperCase().trim());
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid method! Choose from the list.");
      }
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

}
