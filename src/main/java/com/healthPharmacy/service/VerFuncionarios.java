package com.healthPharmacy.service;

import com.healthPharmacy.model.Funcionario;

import java.util.List;
import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class VerFuncionarios {
    public static void verFuncionarios() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lista de Funcionarios cadastrados\n");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            List<Funcionario> funcionarios = query.getResultList();

            if (funcionarios.isEmpty()) {
                System.out.println("Nao ha funcionarios cadastrados.");
            } else {
                System.out.println("Lista de Funcionarios:");
                for (Funcionario funcionario : funcionarios) {
                    System.out.println(funcionario);
                }
            }
        } finally {
            em.close();
            emf.close();
        }
        System.out.println("Pressione enter para retornar ao menu de administracao.");
        sc.nextLine();
        MenuAdm.menuADM();
    }
}
