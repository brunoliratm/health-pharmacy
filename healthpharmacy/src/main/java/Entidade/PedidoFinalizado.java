package Entidade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PedidoFinalizado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<ItemPedido> itens = new ArrayList<>();

    private LocalDateTime dataHora;
    private double valorTotal;

    // Construtores
    public PedidoFinalizado() {}

    public PedidoFinalizado(Cliente cliente, List<ItemPedido> itens) {
        this.cliente = cliente;
        this.itens = itens;
        this.dataHora = LocalDateTime.now();
        this.valorTotal = calcularValorTotal();
    }

    private double calcularValorTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Cliente getCliente() {
      return cliente;
    }

    public void setCliente(Cliente cliente) {
      this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
      return itens;
    }

    public void setItens(List<ItemPedido> itens) {
      this.itens = itens;
    }

    public LocalDateTime getDataHora() {
      return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
      this.dataHora = dataHora;
    }

    public double getValorTotal() {
      return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
      this.valorTotal = valorTotal;
    }
}

