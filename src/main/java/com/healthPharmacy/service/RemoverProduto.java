package com.healthPharmacy.service;

import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.healthPharmacy.model.Funcionario;
import com.healthPharmacy.model.Produto;
import com.healthPharmacy.GUI.MenuProdutos;

public class RemoverProduto {
    public static void removerProduto(Funcionario funcionario) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Remoçao de produto\n");
        System.out.print("Digite o ID do produto que deseja remover: \n");
        System.out.print("--> ");
        String id = sc.nextLine();

        try {
            Produto produto = em.find(Produto.class, id);

            if (produto != null) {
                em.getTransaction().begin();
                em.remove(produto);
                em.getTransaction().commit();
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Produto nao encontrado.");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erro ao remover produto: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Pressione Enter para continuar...");
            sc.nextLine();
            MenuProdutos.menuProdutos(funcionario);
        }
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();
        MenuProdutos.menuProdutos(funcionario);
    }
}