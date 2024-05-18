package GUI;

import java.util.Scanner;

import Entidade.Funcionario;
import Repositorio.RepositorioFuncionario;
import Tratamento.tratamento;

public class MenuFuncionario {
  static Scanner sc = new Scanner(System.in);
  public static void menuFuncionario(Funcionario funcionario1) throws InterruptedException{
    System.out.println("Menu do Funcionário\n\n");
    System.out.println("[1] Gereneciar produtos");
    System.out.println("[2] Informações do funcionários");
    System.out.println("[3] Retornar ao menu de login");
    System.out.println("[4] Sair do aplicativo\n");

    try {
      System.out.print("--> ");
      String escolha = sc.nextLine();
      switch (escolha) {
        case "1":
          MenuProdutos.menuProdutos();
          break;
        case "2":
          for (Funcionario funcionario : RepositorioFuncionario.listaFuncionario) {
            if (funcionario.equals(funcionario1)) {
              System.out.println(funcionario);
              System.out.println("\nPressione Enter para retornar");
              sc.nextLine();
              menuFuncionario(funcionario1);
            }
          }
          break;
        case "3":
          MenuEntrada.menu();
          break;
        case "4":
          System.exit(0);
          break;
        default:
          tratamento.opcaoInvalida();
          menuFuncionario(funcionario1);
          break;
      }
    } catch (Exception e) {
      tratamento.valorInvalido();
      menuFuncionario(funcionario1);
    }
  } 
}