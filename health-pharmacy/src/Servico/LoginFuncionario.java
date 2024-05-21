package Servico;

import java.util.Scanner;
import Entidade.Funcionario;
import GUI.MenuEntrada;
import GUI.MenuFuncionario;
import Repositorio.RepositorioFuncionario;
import Tratamento.tratamento;

public class LoginFuncionario {
  static Scanner sc = new Scanner(System.in);

    public static void loginFuncionario() throws InterruptedException {
        System.out.println("Login do Funcionario\n");

        try {
                System.out.println("Digite seu CPF: ");
                String CPF = sc.nextLine();
                System.out.println("Digite sua senha: ");
                String senha = sc.nextLine();

                for (Funcionario funcionario : RepositorioFuncionario.listaFuncionario) {
                    if (funcionario.getCPF().equals(CPF) && funcionario.getSenha().equals(senha)) {
                        System.out.println("Login efetuado com sucesso!");
                        Thread.sleep(2000);
                        Funcionario funcionario1 = funcionario;
                        MenuFuncionario.menuFuncionario(funcionario1);
                        break;
                    }else {
                        tratamento.contaInvalida(); 
                        MenuEntrada.menuLogin();
                    }
                } 
        } catch (Exception e) {
            tratamento.valorInvalido();
            MenuEntrada.menuLogin();
        }
    }

}
