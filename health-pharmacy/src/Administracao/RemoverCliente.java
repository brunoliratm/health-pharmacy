package Administracao;

import java.util.Scanner;

import Entidade.Cliente;
import Repositorio.RepositorioCliente;

public class RemoverCliente {
  public static void removerCliente() throws InterruptedException{
    Scanner sc = new Scanner(System.in);
    System.out.println("Desligamento de cliente\n");
    System.out.println("Digite o CPF do cliente que deseja remover: ");
    System.out.print("--> ");
    String id = sc.nextLine();
    for(Cliente cliente : RepositorioCliente.listaClientes){
      if(cliente.getCPF().equals(id)){
        RepositorioCliente.listaClientes.remove(cliente);
        System.out.println("Cliente removido com sucesso!");
        sc.close();
        Thread.sleep(2000);
        MenuAdm.menuADM(sc);
        break;
      }
    }
    System.out.println("Cliente não encontrado!");
    sc.close();
    Thread.sleep(2000);
    MenuAdm.menuADM(sc);
  }
}
