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

        try {
            System.out.print("CPF(apenas os digitos, sem pontuacao): ");
            String CPFFuncionario = sc.nextLine();
            CPFFuncionario = CPFFuncionario.replaceAll("[^0-9]", "");
            if (CPFFuncionario.length() != 14) {
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

            for (Funcionario funcionario : RepositorioFuncionario.listaFuncionario) {
                if (funcionario.getCPF().equals(CPFFuncionario) || funcionario.getEmail().equals(emailFuncionario)) {
                    tratamento.contaJaExiste();
                    MenuEntrada.menuRegistro();
                } else {
                    Funcionario Funcionario1 = new Funcionario(nome, emailFuncionario, telefoneFuncionario, CargoFuncionario, SenhaFuncionario, CPFFuncionario);
                    RepositorioFuncionario.addFuncionario(Funcionario1);
                    Thread.sleep(1000);
                    System.out.println("Conta cadastrada com sucesso!");
                    Thread.sleep(2000);
                    sc.close();
                    MenuFuncionario.menuFuncionario(Funcionario1);
                }
            }
        } catch (Exception e) {
            tratamento.valorInvalido();
            cadastroFuncionario();

        }
    }
}