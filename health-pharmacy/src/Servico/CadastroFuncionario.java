package Servico;

import java.util.Scanner;
import Entidade.Funcionario;
import GUI.MenuEntrada;
import GUI.MenuFuncionario;
import Repositorio.RepositorioFuncionario;
import Tratamento.*;

public class CadastroFuncionario {

    public static void cadastroFuncionario() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastrando novo funcionario:\n");
        Thread.sleep(1000);
        boolean cadastro = false;
        try {
            System.out.print("CPF(apenas os digitos, sem pontuacao): ");
            String CPFFuncionario = sc.nextLine();
            CPFFuncionario = CPFFuncionario.replaceAll("[^0-9]", "");
            if (CPFFuncionario.length() != 11) {
                tratamento.CPFInvalido();
                cadastroFuncionario();
            }
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Senha: ");
            String SenhaFuncionario = sc.nextLine();
            System.out.print("Email: ");
            String emailFuncionario = sc.nextLine();
            System.out.print("Telefone: ");
            String telefoneFuncionario = sc.nextLine();
            System.out.print("Cargo: ");
            String CargoFuncionario = sc.nextLine();
            if (!cadastro) {
                if (RepositorioFuncionario.listaFuncionario.isEmpty()){
                    Funcionario Funcionario1 = new Funcionario(nome, emailFuncionario, telefoneFuncionario, CargoFuncionario, SenhaFuncionario, CPFFuncionario);
                    Thread.sleep(1000);
                    System.out.println("Conta cadastrada com sucesso!");
                    Thread.sleep(2000);
                    RepositorioFuncionario.addFuncionario(Funcionario1);
                    MenuFuncionario.menuFuncionario(Funcionario1);
                }
                for (Funcionario funcionario : RepositorioFuncionario.listaFuncionario) {
                    if (funcionario.getCPF().equals(CPFFuncionario) || funcionario.getEmail().equals(emailFuncionario)) {
                        tratamento.contaJaExiste();
                        MenuEntrada.menuRegistro();
                    } else {
                        Funcionario Funcionario2 = new Funcionario(nome, emailFuncionario, telefoneFuncionario, CargoFuncionario, SenhaFuncionario, CPFFuncionario);
                        Thread.sleep(1000);
                        System.out.println("Conta cadastrada com sucesso!");
                        Thread.sleep(2000);
                        RepositorioFuncionario.addFuncionario(Funcionario2);
                        MenuFuncionario.menuFuncionario(Funcionario2);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            sc.nextLine();
            System.out.println();
            tratamento.valorInvalido();
            cadastroFuncionario();

        }
        sc.close();
    }
}