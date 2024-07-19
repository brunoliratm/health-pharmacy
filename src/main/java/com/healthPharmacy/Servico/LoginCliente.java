package com.healthPharmacy.Servico;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;


import com.healthPharmacy.Entidade.Cliente;
import com.healthPharmacy.Tratamento.tratamento;
import com.healthPharmacy.GUI.MenuCliente;
import com.healthPharmacy.GUI.MenuEntrada;


public class LoginCliente {

    public static void loginCliente() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Login de Cliente\n");
        Thread.sleep(1000);

        System.out.print("CPF: ");
        String cpf = sc.nextLine().replaceAll("[^0-9]", "");

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        try {
            Cliente cliente = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.CPF = :cpf AND c.senha = :senha", Cliente.class
            )
            .setParameter("cpf", cpf)
            .setParameter("senha", senha)
            .getSingleResult();

            em.close();
            emf.close();
            System.out.println("Login realizado com sucesso!");
            Thread.sleep(1500);
            MenuCliente.menuCliente(cliente);
        } catch (NoResultException e) {
            tratamento.contaInvalida();
            em.close();
            emf.close();
            MenuEntrada.menuLogin();
        }
    }
}