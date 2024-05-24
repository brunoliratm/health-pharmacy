package Administracao;

import java.util.Scanner;
import Entidade.Funcionario;
import Repositorio.RepositorioFuncionario;

public class RemoverFuncionario {
    public static void removerFuncionario() throws InterruptedException {
      Scanner sc = new Scanner(System.in);
        System.out.println("Desligamento de funcionário\n");
        System.out.println("Digite o CPF do funcionário que deseja remover: ");
        System.out.print("--> ");
        String id = sc.nextLine();
        for(Funcionario funcionario : RepositorioFuncionario.listaFuncionario){
            if(funcionario.getCPF().equals(id)){
                RepositorioFuncionario.listaFuncionario.remove(funcionario);
                System.out.println("Funcionário removido com sucesso!");
                Thread.sleep(2000);
                MenuAdm.menuADM(sc);
                break;
            }
        }
        System.out.println("Funcionário não encontrado!");
        Thread.sleep(2000);
        MenuAdm.menuADM(sc);

    }

}
