package Administracao;

import java.util.Scanner;

import GUI.MenuEntrada;

public class MenuAdm {
    public static void menuADM(Scanner sc) throws InterruptedException{
        sc.nextLine();
        System.out.println("Menu de Administração\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] Remover Funcionário");
        System.out.println("[2] Remover Cliente");
        System.out.println("[3] Histórico de vendas");
        System.out.println("[4] Ver clientes cadastrados");
        System.out.println("[5] Ver funcionários cadastrados");
        System.out.println("[6] Retornar ao menu de login");
        System.out.println("[7] Sair do aplicativo\n");
        System.out.print("--> ");

        String opcao = sc.nextLine();
        switch(opcao){
            case "1":
                RemoverFuncionario.removerFuncionario();
                break;
            case "2":
                RemoverCliente.removerCliente();
                break;
            case "3":
                //HistoricoVendas.historicoVendas();
                break;
            case "4":
                VerClientes.verClientes();
                break;
            case "5":
                VerFuncionarios.verFuncionarios();
                break;
            case "6":
                MenuEntrada.menu();
                break;
            case "7":
            System.out.println("Obrigado pela confiança, volte sempre!");
                Thread.sleep(2000);
                System.exit(0);
                sc.close();
                break;
            default:
                System.out.println("Opção inválida!");
                Thread.sleep(2000);
                menuADM(sc);
                break;
        }

    }
}
