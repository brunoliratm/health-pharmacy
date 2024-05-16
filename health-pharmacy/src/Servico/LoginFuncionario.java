package Servico;

import java.util.Scanner;
import Entidade.Funcionario;
import GUI.MenuFuncionario;
import Repositorio.RepositorioFuncionario;
import Tratamento.tratamento;

public class LoginFuncionario {
  static Scanner sc = new Scanner(System.in);

    public static void loginFuncionario() throws InterruptedException {
        System.out.println("Login do Funcionario\n");

        try {
            boolean loginSuccess = false;
            do {
                System.out.println("Digite seu CNPJ: ");
                String cnpj = sc.nextLine();
                System.out.println("Digite sua senha: ");
                String senha = sc.nextLine();

                for (Funcionario funcionario : RepositorioFuncionario.listaFuncionario) {
                    if (funcionario.getCNPJ().equals(cnpj) && funcionario.getSenha().equals(senha)) {
                        System.out.println("Login efetuado com sucesso!");
                        Thread.sleep(2000);
                        loginSuccess = true;
                        break;
                    }
                }
                if (loginSuccess) {
                    MenuFuncionario.menuFuncionario();
                } else {
                    tratamento.contaInvalida();
                   
                }
            } while (!loginSuccess);
        } catch (Exception e) {
            tratamento.valorInvalido();
 
        }
    }

}
