package com.healthPharmacy.Servico;

import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import com.healthPharmacy.Entidade.Funcionario;
import com.healthPharmacy.Tratamento.tratamento;
import com.healthPharmacy.GUI.MenuFuncionario;
import com.healthPharmacy.GUI.MenuEntrada;


public class LoginFuncionario {

    public static void loginFuncionario() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Login do Funcionario\n");
        Thread.sleep(1000);

        System.out.print("CPF: ");
        String cpf = sc.nextLine().replaceAll("[^0-9]", "");

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        try {
            Funcionario funcionario = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.CPF = :cpf AND f.senha = :senha", Funcionario.class
            )
            .setParameter("cpf", cpf)
            .setParameter("senha", senha)
            .getSingleResult();

            System.out.println("Login realizado com sucesso!");
            Thread.sleep(1500);
            em.close();
            emf.close();
            MenuFuncionario.menuFuncionario(funcionario);
        } catch (NoResultException e) {
            tratamento.contaInvalida();
            em.close();
            emf.close();
            MenuEntrada.menuLogin();
        }
    }
}