package com.healthPharmacy.Servico;

import com.healthPharmacy.Entidade.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class VizualizarProduto {
  public static void visualizarProdutosDisponiveis() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
    List<Produto> produtos = query.getResultList();

    if (produtos.isEmpty()) {
      System.out.println("\nNao ha produtos disponiveis no momento.");
    } else {
      System.out.println("Produtos Disponiveis:\n");
      for (Produto produto : produtos) {
        System.out.println(produto);
      }
    }

    em.close();
    emf.close();
    Scanner sc = new Scanner(System.in);
    System.out.print("\nPressione Enter para voltar ao menu anterior.");
    sc.nextLine();
  }
}
