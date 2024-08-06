package com.healthPharmacy.model;

import com.healthPharmacy.model.Produto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity

public class PedidoFinalizado {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientes_cpf")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<ItemPedido> itens = new ArrayList<>();

    private LocalDateTime dataHora;
    @Column(name = "custo_total")
    private double valorTotal;


    public PedidoFinalizado() {
    }

    public PedidoFinalizado(Cliente cliente, List<ItemPedido> itens) {
        this.cliente = cliente;
        this.itens = itens;
        this.dataHora = LocalDateTime.now();
        this.valorTotal = calcularValortotal();
    }

    private double calcularValortotal() {
        return itens.stream().mapToDouble(item -> item.getProduto().getPreco() * item.getProduto().getQuantidade()).sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
