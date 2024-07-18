package com.healthPharmacy.Servico;

import com.healthPharmacy.Entidade.Cliente;
import com.healthPharmacy.Entidade.ItemPedido;
import com.healthPharmacy.Entidade.PedidoFinalizado;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class ExibirHistoricoCompras {
  public static void exibirHistoricoCompras(Cliente cliente) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();

    TypedQuery<PedidoFinalizado> query = em.createQuery("SELECT p FROM PedidoFinalizado p WHERE p.cliente = :cliente",
        PedidoFinalizado.class);
    query.setParameter("cliente", cliente);
    List<PedidoFinalizado> pedidos = query.getResultList();

    if (pedidos.isEmpty()) {
      System.out.println("Você ainda nao fez nenhuma compra.");
    } else {
      System.out.println("Historico de Compras:");
      for (PedidoFinalizado pedido : pedidos) {
        System.out.println("\n------------------------");
        System.out.println("Pedido #" + pedido.getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // Define o formato desejado
        String dataFormatada = pedido.getDataHora().format(formatter);
        System.out.println("Data: " + dataFormatada);
        System.out.println("Valor Total: R$ " + String.format("%.2f", pedido.getValorTotal()));

        for (ItemPedido item : pedido.getItens()) {
          System.out.println("Produto: " + item.getProduto().getNome() + "\nMarca:" + item.getProduto().getMarca() + "\nQuantidade: " + item.getQuantidade() + "\n");
        }
      }
    }

    em.close();
    emf.close();
    Scanner sc = new Scanner(System.in);
    System.out.print("\nPressione Enter para voltar ao menu anterior.");
    sc.nextLine();
  }
}