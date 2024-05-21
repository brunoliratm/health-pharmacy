package GUI;

import Entidade.Cliente;
import Repositorio.RepositorioCliente;
import Tratamento.tratamento;
import java.util.Scanner;

public class MenuCliente {
  static Scanner sc = new Scanner(System.in);
  public static void menuCliente(Cliente cliente1) throws InterruptedException{
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
      System.out.print("-->");
      String escolha = sc.nextLine();

      switch (escolha) {
        case "1":
          
          break;
        case "4":
          for(Cliente cliente : RepositorioCliente.listaClientes){
            if (cliente.equals(cliente1)) {
              System.out.println(cliente);
            }
          }
          MenuCliente.menuCliente(cliente1);
        case "6":
          MenuEntrada.menu();
          break;
        case "7":
          System.exit(0);
          break;
        default:
          break;
      }
      
    } catch (Exception e) {
      tratamento.valorInvalido();
      menuCliente(cliente1);
    }
  }
}
