package Servico;

import java.util.Scanner;
import Entidade.Funcionario;
import Repositorio.FuncionarioRepositorio;
import Tratamento.*;

public class CadastroFuncionario {
    
    public void cadastroFuncionario() throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastrando novo funcionario:\n");
        Thread.sleep(1000);

        try{
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Cnpj: ");
            String cnpjFuncionario = sc.nextLine();
            System.out.print("Email: ");
            String emailFuncionario = sc.nextLine();
            System.out.print("Telefone: ");
            String telefoneFuncionario = sc.nextLine();
            System.out.print("Cargo: ");
            String CargoFuncionario = sc.nextLine();
            System.out.print("Senha: ");
            String SenhaFuncionario = sc.nextLine();

            Funcionario Funcionario1 = new Funcionario(nome,emailFuncionario, telefoneFuncionario, CargoFuncionario, SenhaFuncionario , cnpjFuncionario);
            FuncionarioRepositorio.addFuncionario(Funcionario1);
            Thread.sleep(1000);
            System.out.println("Funcionario cadastrado");
            Thread.sleep(2000);
            sc.close();
        }catch(Exception e){
            tratamento.valorInvalido();
            cadastroFuncionario();
        }
    }
}
