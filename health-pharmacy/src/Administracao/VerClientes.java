package Administracao;

import Entidade.Cliente;
import Repositorio.RepositorioCliente;
import java.util.Scanner;

public class VerClientes {
    public static void verClientes() throws InterruptedException {
      Scanner sc = new Scanner(System.in);
        System.out.println("Clientes cadastrados: ");
        for (Cliente cliente : RepositorioCliente.listaClientes) {
            System.out.println(cliente);
        }

        System.out.println("Pressione enter para retornar ao menu de administração.");
        sc.nextLine();
        MenuAdm.menuADM(sc);
    }

}
