package Servico;

import java.util.Scanner;
import Entidade.Cliente;
import GUI.MenuCliente;
import GUI.MenuEntrada;
import Repositorio.RepositorioCliente;
import Tratamento.tratamento;

public class LoginCliente {
  static Scanner sc = new Scanner(System.in);

    public static void loginCliente() throws InterruptedException {
        System.out.println("Login de Cliente\n");

        try {
                System.out.println("Digite seu CPF: ");
                String cpf = sc.nextLine();
                System.out.println("Digite sua senha: ");
                String senha = sc.nextLine();

                for (Cliente cliente : RepositorioCliente.listaClientes) {
                    if (cliente.getCPF().equals(cpf) && cliente.getSenha().equals(senha)) {
                        System.out.println("Login efetuado com sucesso!");
                        Thread.sleep(2000);
                        Cliente cliente1 = cliente;
                        MenuCliente.menuCliente(cliente1);
                        break;
                    } else {
                        tratamento.contaInvalida();    
                        MenuEntrada.menuLogin();
                        break;   
                    }
                }    
        } catch (Exception e) {
            tratamento.valorInvalido();
            MenuEntrada.menuLogin();
        }
    }
}
