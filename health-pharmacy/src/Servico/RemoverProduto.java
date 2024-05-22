package Servico;

import java.util.Scanner;

import Entidade.Funcionario;
import GUI.MenuProdutos;
import Repositorio.RepositorioProduto;

public class RemoverProduto {
  public static void removerProduto(Scanner sc) throws InterruptedException {
    boolean produtoEncontrado = false;
    System.out.println("Remoção de produto\n");
    System.out.println("Digite o ID do produto que deseja remover: \n");
    System.out.print("--> ");
    String id = sc.nextLine();

    for (int i = 0; i < RepositorioProduto.listaProduto.size(); i++) {
      if (RepositorioProduto.listaProduto.get(i).getId().equals(id)) {
        RepositorioProduto.listaProduto.remove(i);
        System.out.println("Produto removido com sucesso!");
        produtoEncontrado=true;
        break;
      }
    }
    if (produtoEncontrado==false) System.out.println("Produto não encontrado!");
    Thread.sleep(2000);
    
  }
}