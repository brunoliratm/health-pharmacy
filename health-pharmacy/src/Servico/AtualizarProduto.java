package Servico;

import java.util.Scanner;
import Entidade.Produto;
import Repositorio.RepositorioProduto;

public class AtualizarProduto {
  public static void atualizarProduto() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Atualização de produto:\n");
    System.out.println("Digite o ID do produto que deseja atualizar: ");

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
        System.out.println("Produto atualizado com sucesso!");
        sc.close();
        break;
      }
    }
  }
}
