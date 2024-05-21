package Servico;

import java.util.Scanner;

import Entidade.Funcionario;
import Entidade.Produto;
import GUI.MenuProdutos;
import Repositorio.RepositorioProduto;

public class AtualizarProduto {
  public static void atualizarProduto(Funcionario funcionario1) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Atualização de produto:\n");
    System.out.println("Digite o ID do produto que deseja atualizar: ");

    System.out.print("--> ");
    String id = sc.nextLine();
    for (Produto produto : RepositorioProduto.listaProduto) {
      if (produto.getId().equals(id)) {
        System.out.println("Produto encontrado!\n");
        System.out.println("Digite o novo nome do produto: ");
        String nome = sc.nextLine();
        produto.setNome(nome);
        System.out.println("Digite o novo preço do produto: ");
        float preco = sc.nextFloat();
        produto.setPreco(preco);
        System.out.println("Digite a nova quantidade do produto: ");
        int quantidade = sc.nextInt();
        produto.setQuantidade(quantidade);
        System.out.println("Digite a nova marca do produto: ");
        sc.nextLine();
        String marca = sc.nextLine();
        produto.setMarca(marca);
        System.out.println("Produto atualizado com sucesso!");
        Thread.sleep(2000);
        sc.close();
        MenuProdutos.menuProdutos(funcionario1);
        break;
      }
    }
  }
}