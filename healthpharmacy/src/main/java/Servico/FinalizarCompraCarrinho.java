package Servico;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import Entidade.Carrinho;
import Entidade.Produto;
import Entidade.PedidoFinalizado;
import Entidade.ItemPedido;


public class FinalizarCompraCarrinho {
    public static void finalizarCompraCarrinho(Carrinho carrinho, EntityManager em) throws InterruptedException {
        if (carrinho.getProdutos().isEmpty()) {
            System.out.println("Seu carrinho esta vazio. Nao e possível finalizar a compra.");
            return;
        }
        try {
            List<ItemPedido> itensPedido = new ArrayList<>();
            for (Produto produto : carrinho.getProdutos()) {
                ItemPedido item = new ItemPedido();
                item.setProduto(produto);
                item.setQuantidade(produto.getQuantidade());
                item.setPreco(produto.getPreco());
                itensPedido.add(item);
            }

            PedidoFinalizado pedido = new PedidoFinalizado(carrinho.getCliente(), itensPedido);

            em.getTransaction().begin();
            em.persist(pedido);
            for (ItemPedido item : itensPedido) {
                em.persist(item);
            }
            em.getTransaction().commit();

            System.out.println("Compra finalizada com sucesso!");

            carrinho.getProdutos().clear();
            em.getTransaction().begin();
            em.merge(carrinho);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erro ao finalizar a compra: " + e.getMessage());
        }
        Thread.sleep(1500);
    }
}
