package com.healthpharmacy.presentation.ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import com.healthpharmacy.application.dto.request.CustomerRequestDTO;
import com.healthpharmacy.application.dto.request.CustomerUpdateRequestDTO;
import com.healthpharmacy.domain.port.service.CustomerUseCase;
import com.healthpharmacy.presentation.ui.util.ConsoleUtils;

public class CustomerMenu {

  private final CustomerUseCase customerService;
  private final Scanner scanner;

  public CustomerMenu(CustomerUseCase customerService, Scanner scanner) {
    this.customerService = customerService;
    this.scanner = scanner;
  }

  public void display() {
    while (true) {
      ConsoleUtils.clear();
      System.out.println("--- Customer Management ---\n");
      System.out.println("[1] Register new client");
      System.out.println("[2] List all customers");
      System.out.println("[3] Find by CPF");
      System.out.println("[4] Update customer registration");
      System.out.println("[5] Remove customer");
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
          case "3" -> handleFindByCpf();
          case "4" -> handleUpdate();
          case "5" -> handleDelete();
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

  private void handleDelete() {
    System.out.println("> Remove customer <\n");
    System.out.print("CPF: ");
    String cpf = scanner.nextLine();
    System.out.println("Are you sure? (Y/N)");
    if (scanner.nextLine().equalsIgnoreCase("Y")) {
      customerService.delete(cpf);
      System.out.println("Removed customer (deactivated)");
    }
  }

  private void handleListAll() {
    System.out.println("> Customer List <\n");

    var customers = customerService.listAll();
    if (customers.isEmpty()) {
      System.out.println("No registered customers");
    } else {
      customers.forEach(c -> System.out.printf("CPF: %s | Name : %s | Email: %s | Age: %d%n", c.cpf(), c.name(),
          c.email(), c.age()));
    }
  }

  private void handleRegister() {
    System.out.println("> Register a new customer <\n");
    System.out.print("CPF (numbers only): ");
    String cpf = scanner.nextLine();
    System.out.print("Name: ");
    String name = scanner.nextLine();
    System.out.print("E-mail: ");
    String email = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();
    LocalDate birthDate = readDate("Date of Birth (YYYY-MM-DD): ");

    var request = new CustomerRequestDTO(cpf, name, password, email, birthDate);
    customerService.register(request);
    System.out.println("Customer successfully registered!");
  }

  private void handleFindByCpf() {
    System.out.println("> Find customer by CPF <\n");
    System.out.print("CPF: ");
    String cpf = scanner.nextLine();

    customerService.findByCpf(cpf).ifPresentOrElse(
        c -> System.out.printf("%s - %s (%d years)", c.name(), c.email(), c.age()),
        () -> System.out.println("Customer not found."));
  }

  private void handleUpdate() {
    System.out.println("> Update customer <\n");
    System.out.print("Enter the CPF of the customer you wish to update: ");
    String cpf = scanner.nextLine();
    System.out.println("(Leave blank to keep the field unchanged)");

    System.out.print("New name: ");
    String name = scanner.nextLine();
    name = name.isBlank() ? null : name;

    System.out.print("New email: ");
    String email = scanner.nextLine();
    email = email.isBlank() ? null : email;

    System.out.print("New password: ");
    String password = scanner.nextLine();
    password = password.isBlank() ? null : password;
    
    LocalDate birthDate = readDateUpdate("New date of birth (YYYY-MM-DD): ");

    var request = new CustomerUpdateRequestDTO(name, password, email, birthDate);
    customerService.update(cpf, request);
    System.out.println("Updated data!");
  }

  private LocalDate readDate(String message) {
    while (true) {
      try {
        System.out.print(message);
        return LocalDate.parse(scanner.nextLine());
      } catch (DateTimeParseException e) {
        System.out.println("Invalid date format! Use YYYY-MM-DD.");
      }
    }
  }

  private LocalDate readDateUpdate(String message) {
    while (true) {
      System.out.print(message);
      String input = scanner.nextLine();

      if (input.isBlank())
        return null;

      try {
        return LocalDate.parse(input);
      } catch (DateTimeParseException e) {
        System.out.println("Invalid date format! Use YYYY-MM-DD.");
      }
    }
  }
}
