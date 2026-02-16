package com.healthpharmacy;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.healthpharmacy.application.service.CustomerService;
import com.healthpharmacy.application.service.OrderService;
import com.healthpharmacy.application.service.ProductService;
import com.healthpharmacy.infrastructure.repository.CustomerRepositoryImpl;
import com.healthpharmacy.infrastructure.repository.OrderRepositoryImpl;
import com.healthpharmacy.infrastructure.repository.ProductRepositoryImpl;
import com.healthpharmacy.presentation.ui.CheckoutMenu;
import com.healthpharmacy.presentation.ui.CustomerMenu;
import com.healthpharmacy.presentation.ui.MainMenuUI;
import com.healthpharmacy.presentation.ui.ProductMenu;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    Scanner scanner = new Scanner(System.in);

    var customerRepo = new CustomerRepositoryImpl(em);
    var productRepo = new ProductRepositoryImpl(em);
    var orderRepo = new OrderRepositoryImpl(em);

    var customerService = new CustomerService(customerRepo);
    var productService = new ProductService(productRepo);
    var orderService = new OrderService(orderRepo, customerService, productService);

    var customerMenu = new CustomerMenu(customerService, scanner);
    var productMenu = new ProductMenu(productService, scanner);
    var orderMenu = new CheckoutMenu(orderService, scanner);

    var mainUI = new MainMenuUI(scanner, customerMenu, productMenu, orderMenu);

    mainUI.start();
    
    em.close();
    emf.close();
    scanner.close();
  }
}
