package GUI;

import Entidade.Cliente;
import Repositorio.RepositorioCliente;
import Servico.VizualizarProduto;
import Tratamento.tratamento;
import java.util.Scanner;

public class MenuCliente {

  public static void menuCliente(Scanner sc,Cliente cliente1) throws InterruptedException{


    System.out.println("Menu do Cliente\n\n");
    Thread.sleep(1500);
    System.out.println("[1] Comprar produto");
    System.out.println("[2] Vizualizar produtos disponíveis");
    System.out.println("[3] Historico de Compras");
    System.out.println("[4] Informações do cliente");
    System.out.println("[5] Carrinho de Compras");
    System.out.println("[6] Retornar ao menu de login");
    System.out.println("[7] Sair do aplicativo");

    try {
      System.out.print("--> ");
      int escolha = sc.nextInt();
      switch (escolha) {
        case 1:
          VizualizarProduto.comprarProduto(sc);
          MenuCliente.menuCliente(sc, cliente1);
          break;
        case 2:
          VizualizarProduto.vizualizarProduto(sc);
          MenuCliente.menuCliente(sc, cliente1);
          break;
        case 3:
          System.out.println("Seu histórico");
          Thread.sleep(1500);
          MenuCliente.menuCliente(sc, cliente1);
          break;
        case 4:
          System.out.println(cliente1);
          MenuCliente.menuCliente(sc, cliente1);
          break;
        case 6:
          break;
        case 7:
          System.exit(0);
          break;
        default:
          sc.nextLine();
          System.out.println();
          tratamento.opcaoInvalida();
          menuCliente(sc, cliente1);
          break;
      }
      
    } catch (Exception e) {
      sc.nextLine();
      System.out.println();
      tratamento.valorInvalido();
      menuCliente(sc, cliente1);
    }
  }
}
