package Administracao;

import Entidade.Funcionario;
import Repositorio.RepositorioFuncionario;
import java.util.Scanner;

public class VerFuncionarios {
    public static void verFuncionarios() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Funcionários cadastrados: ");
        for (Funcionario funcionario : RepositorioFuncionario.listaFuncionario) {
            System.out.println(funcionario);
        }
        System.out.println("Pressione enter para retornar ao menu de administração.");
        sc.nextLine();
        sc.close();
        MenuAdm.menuADM();
    }

}
