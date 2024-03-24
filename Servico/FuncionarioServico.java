package Servico;

import java.util.Scanner;

import Entidade.Funcionario;
import Repositorio.FuncionarioRepositorio;

public class FuncionarioServico {
    CadastroSenha cadastroSenha = new CadastroSenha();
    
    public void cadastroFuncionario() throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastrando novo funcionario:");
        System.out.println("");
        Thread.sleep(1000);
        System.out.print("Nome: ");
        String nome = sc.nextLine(); 
        System.out.print("\nCnpj: ");
        String cnpjFuncionario = sc.nextLine();
        System.out.print("\nEmail: ");
        String emailFuncionario = sc.nextLine();
        System.out.print("\nTelefone: ");
        String telefoneFuncionario = sc.nextLine();
        System.out.print("\nCargo: ");
        String CargoFuncionario = sc.nextLine();
        System.out.print("\nSalário: ");
        Float SalarioFuncionario = sc.nextFloat();
        
        String SenhaFuncionario=cadastroSenha.cadastroSenha();
        Funcionario Funcionario1 = new Funcionario(nome,emailFuncionario, telefoneFuncionario, CargoFuncionario, SalarioFuncionario, SenhaFuncionario , cnpjFuncionario);
        FuncionarioRepositorio.addFuncionario(Funcionario1);
        System.out.println("Funcionario cadastrado");
        sc.close();
    }
}
