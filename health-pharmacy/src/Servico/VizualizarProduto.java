package Servico;

import java.util.Scanner;

import Entidade.Funcionario;
import Entidade.Produto;
import GUI.MenuProdutos;
import Repositorio.RepositorioProduto;

public class VizualizarProduto {
  public static void vizualizarProduto(Funcionario funcionario1) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Produtos disponíveis: ");

    for (Produto produto : RepositorioProduto.listaProduto) {
      System.out.println(produto);
    }

    Thread.sleep(2000);
    System.out.println("Pressione ENTER para retornar ao menu de produtos");
    sc.nextLine();
    sc.close();
    MenuProdutos.menuProdutos(funcionario1);
  }
}