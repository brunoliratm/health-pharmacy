package com.healthpharmacy.presentation.ui;

import java.util.Scanner;
import com.healthpharmacy.presentation.ui.util.ConsoleUtils;

public class MainMenuUI {

  private final Scanner scanner;
  private final CustomerMenu customerMenu;
  private final ProductMenu productMenu;
  private final CheckoutMenu checkoutMenu;

  public MainMenuUI(Scanner scanner, CustomerMenu customerMenu, ProductMenu productMenu, CheckoutMenu checkoutMenu) {
    this.scanner = scanner;
    this.customerMenu = customerMenu;
    this.productMenu = productMenu;
    this.checkoutMenu = checkoutMenu;
  }

  public void start() {
    while (true) {
      ConsoleUtils.clear();
      System.out.println("Health Pharmacy - CLI");
      System.out.println("by Bruno Magno\n");
      System.out.println("[1] - Manage Clients");
      System.out.println("[2] - Manage Products");
      System.out.println("[3] - Checkout (sale)");
      System.out.println("[0] - Exit\n");
      System.out.print("Option: ");

      String option = scanner.nextLine();

      switch (option) {
        case "1" -> customerMenu.display();
        case "2" -> productMenu.display();
        case "3" -> checkoutMenu.display();
        case "0" -> {
          System.out.println("Thanks for using our services, See you!");
          ConsoleUtils.handleDelay();
          return;
        }
        default -> {
          System.out.println("Invalid Option, Try Again.");
          ConsoleUtils.handleDelay();
        }
      }
    }
  }

}
