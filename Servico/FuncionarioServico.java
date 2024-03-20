package Servico;

import java.util.Scanner;

import Entidade.Funcionario;
import Repositorio.FuncionarioRepositorio;

public class FuncionarioServico {
    FuncionarioRepositorio listaFuncionario = new FuncionarioRepositorio();
    public void cadastro(){
        Scanner inputFun = new Scanner(System.in);
        System.out.println("Criando funcionario");
        System.out.println("Nome: ");
        String nome = inputFun.nextLine(); 
        System.out.println("Cnpj: ");
        String cnpjFuncionario = inputFun.nextLine();
        System.out.println("Email: ");
        String emailFuncionario = inputFun.nextLine();
        System.out.println("Telefone: ");
        String telefoneFuncionario = inputFun.nextLine();
        Funcionario Funcionario1 = new Funcionario(nome, cnpjFuncionario, telefoneFuncionario, emailFuncionario);
        listaFuncionario.addFuncionario(Funcionario1);
        System.out.println("Funcionario cadastrado");
        
    }
}
