package Servico;

import java.util.Scanner;
import Entidade.Cliente;
import Repositorio.ClienteRepositorio;
import Tratamento.*;

public class CadastroCliente  {
    Scanner sc = new Scanner(System.in);
    public void cadastroCliente() throws InterruptedException{
        System.out.println("Cadastrando novo cliente: \n");
        Thread.sleep(1000);

        try{
            System.out.print("Nome: ");
            String nomeCliente = sc.nextLine();
            System.out.print("Email: ");
            String emailCliente = sc.nextLine();
            System.out.print("Idade: ");
            int idadeCliente = sc.nextInt();
            System.out.print("Endereço: ");
            String enderecoCliente = sc.nextLine();
            System.out.print("Telefone: ");
            String telefoneCliente = sc.nextLine();
            System.out.print("CPF: ");
            String cpfCliente = sc.nextLine();
            System.out.print("Senha: ");
            String SenhaCliente = sc.nextLine();

            Cliente cliente1 = new Cliente(nomeCliente, emailCliente, idadeCliente, enderecoCliente, telefoneCliente, SenhaCliente, cpfCliente);
            ClienteRepositorio.addCliente(cliente1);
            Thread.sleep(1000);
            System.out.println("Cliente cadastrado\n");
            Thread.sleep(2000);
        }catch(Exception e) {
            tratamento.valorInvalido();
            cadastroCliente();
        }
    }
}
