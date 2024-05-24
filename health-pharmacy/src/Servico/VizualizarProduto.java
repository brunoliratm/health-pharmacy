package Servico;

import java.util.Scanner;

import Entidade.Funcionario;
import Entidade.Produto;
import GUI.MenuProdutos;
import Repositorio.RepositorioProduto;
import Tratamento.tratamento;

public class VizualizarProduto {
  public static void vizualizarProduto(Scanner sc) throws InterruptedException {

    System.out.println("Produtos disponíveis: ");

    for (Produto produto : RepositorioProduto.listaProduto) {
      System.out.println(produto);
    }

    System.out.println("Pressione ENTER para retornar ao menu de produtos");
    Thread.sleep(2000);
    sc.nextLine();
    System.out.println();

  }
  public static void comprarProduto(Scanner sc) throws InterruptedException {
    boolean produtoEncontrado = false;
    sc.nextLine();
    System.out.println("Qual produto você deseja comprar?");
    System.out.print("--> ");
    try {
      String nome = sc.nextLine();
      for (Produto produto : RepositorioProduto.listaProduto){
        if (produto.getNome().startsWith(nome) || produto.getMarca().startsWith(nome)){
          System.out.println(produto);
          produtoEncontrado=true;
        }
      }
      if (produtoEncontrado){
        System.out.println("Digite o id do produto que você deseja comprar");
      }else {
        System.out.println("Sentimos muito, não temos nenhum produto "+ nome);
      }

    }catch (Exception e){
      tratamento.valorInvalido();
    }
  }
}