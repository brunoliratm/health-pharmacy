package Servico;

import java.util.Scanner;

import Entidade.Funcionario;
import GUI.MenuProdutos;
import Repositorio.RepositorioProduto;

public class RemoverProduto {
  public static void removerProduto(Funcionario funcionario1) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Remoção de produto\n");
    System.out.println("Digite o ID do produto que deseja remover: \n");
    System.out.print("--> ");
    String id = sc.nextLine();

    for (int i = 0; i < RepositorioProduto.listaProduto.size(); i++) {
      if (RepositorioProduto.listaProduto.get(i).getId().equals(id)) {
        RepositorioProduto.listaProduto.remove(i);
        System.out.println("Produto removido com sucesso!");
        sc.close();
        MenuProdutos.menuProdutos(funcionario1);
        break;
      }
    }
    System.out.println("Produto não encontrado!");
    Thread.sleep(2000);
    sc.close();
    MenuProdutos.menuProdutos(funcionario1);
    
  }
}