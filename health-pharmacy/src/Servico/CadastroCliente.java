package Servico;

import java.util.Scanner;
import Entidade.Cliente;
import GUI.MenuCliente;
import GUI.MenuEntrada;
import Repositorio.RepositorioCliente;
import Tratamento.*;

public class CadastroCliente {
    static Scanner sc = new Scanner(System.in);

    public static void cadastroCliente() throws InterruptedException {
        System.out.println("Cadastrando novo cliente: \n");
        Thread.sleep(1000);

        try {
            System.out.print("CPF (apenas os digitos, sem pontuacao): ");
            String cpfCliente = sc.nextLine();
            cpfCliente = cpfCliente.replaceAll("[^0-9]", "");
            if (cpfCliente.length() != 11) {
                tratamento.cpfInvalido();
                cadastroCliente();
            }
            System.out.print("Nome: ");
            String nomeCliente = sc.nextLine();
            System.out.print("Email: ");
            String emailCliente = sc.nextLine();
            System.out.print("Senha: ");
            String SenhaCliente = sc.nextLine();

            // dados adicionais
            Thread.sleep(1400);
            System.out.println("\nDados adicionais\n");
            System.out.print("Idade: ");
            int idadeCliente = sc.nextInt();
            System.out.print("Endereço: ");
            String enderecoCliente = sc.nextLine();
            System.out.print("Telefone: ");
            String telefoneCliente = sc.nextLine();

            for (Cliente cliente : RepositorioCliente.listaClientes) {
                if (cliente.getCPF().equals(cpfCliente) || cliente.getEmail().equals(emailCliente)) {
                    tratamento.contaJaExiste();
                    MenuEntrada.menu();
                } else {
                    Cliente cliente1 = new Cliente(nomeCliente, emailCliente, idadeCliente, enderecoCliente, telefoneCliente, SenhaCliente, cpfCliente);
                    RepositorioCliente.addCliente(cliente1);
                    Thread.sleep(1000);
                    System.out.println("Conta cadastrada com sucesso!");
                    Thread.sleep(2000);
                    sc.close();
                    MenuCliente.menuCliente();
                }
            }
        } catch (Exception e) {
            tratamento.valorInvalido();
            cadastroCliente();
        }
    }
}
