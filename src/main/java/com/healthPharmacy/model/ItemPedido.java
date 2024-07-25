package com.healthPharmacy.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class ItemPedido implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private PedidoFinalizado pedido;

  private int quantidade;
  private double preco;

  public ItemPedido() {
  }

  public ItemPedido(Long id, Produto produto, int quantidade, double preco) {
    this.id = id;
    this.produto = produto;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }
}