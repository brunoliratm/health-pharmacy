package Servico;

import java.util.Scanner;

import Entidade.Cliente;
import Repositorio.ClienteRepositorio;

public class ClienteServico  {
    Scanner sc = new Scanner(System.in);
    CadastroSenha cadastroSenha = new CadastroSenha();
    public void cadastroCliente() throws InterruptedException{
        System.out.println("Cadastrando novo cliente");
        Thread.sleep(1000);
        System.out.print("Nome: ");
        String nomeCliente = sc.nextLine();
        System.out.print("\nEmail: ");
        String emailCliente = sc.nextLine();
        System.out.print("\nIdade: ");
        int idadeCliente = sc.nextInt();
        System.out.print("\nEndereço: ");
        String enderecoCliente = sc.nextLine();
        System.out.print("\nTelefone: ");
        String telefoneCliente = sc.nextLine();
        System.out.print("\nCPF:");
        String cpfCliente = sc.nextLine();
        String SenhaCliente=cadastroSenha.cadastroSenha();

        Cliente cliente1 = new Cliente(nomeCliente, emailCliente, idadeCliente, enderecoCliente, telefoneCliente, SenhaCliente, cpfCliente);
        ClienteRepositorio.addCliente(cliente1);
        System.out.println("Cliente cadastrado\n");
        Thread.sleep(1000);
        
    }
}
