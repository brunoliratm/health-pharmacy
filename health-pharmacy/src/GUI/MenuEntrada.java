package GUI;

import java.util.Scanner;

import Administracao.MenuAdm;
import Servico.CadastroCliente;
import Servico.CadastroFuncionario;
import Servico.LoginCliente;
import Servico.LoginFuncionario;
import Tratamento.*;

public class MenuEntrada {
    static Scanner sc = new Scanner(System.in);

    //Menu Inicial
    public static void menu() throws InterruptedException {
        Limpeza.limpeza();
        System.out.println("  HEALTH  PHARMACY\n");
        Thread.sleep(2000);

        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] Se Registrar");
        System.out.println("[2] Logar");
        System.out.println("[3] Área da Administração");
        System.out.println("[4] Sair do Aplicativo\n");


        try {
            System.out.print("--> ");
            int escolha = sc.nextInt();
            Limpeza.limpeza();
            switch (escolha) {
                case 1:
                    menuRegistro();
                    break;
                case 2:
                    menuLogin();
                    break;
                case 3:
                    MenuAdm.menuADM();
                    break;
                case 4:
                    System.out.println("Obrigado pela confiança, volte sempre!");
                    Thread.sleep(2000);
                    sc.close();
                    System.exit(0);
                default:
                    tratamento.opcaoInvalida();
                    menu();
            }
        } catch (Exception e) {
            sc.nextLine();
            tratamento.opcaoInvalida();
            menu();
        }
    }

    //Menu de Login
    public static void menuLogin() throws InterruptedException{
        System.out.println("Menu de Login\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] Entrar como cliente");
        System.out.println("[2] Entrar como Funcionário");
        System.out.println("[3] retornar ao menu anterior\n");

        try{
            System.out.print("--> ");
            int escolha = sc.nextInt();
            Limpeza.limpeza();
            switch (escolha) {
                case 1:
                    LoginCliente.loginCliente();
                    break;
                case 2:
                    LoginFuncionario.loginFuncionario();
                    break;
                case 3:
                    menu();
                    break;
                default:
                    sc.nextLine();
                    tratamento.opcaoInvalida();
                    Limpeza.limpeza();
                    menuRegistro();
                    break;
            }
        } catch (Exception e) {
            sc.nextLine();
            tratamento.opcaoInvalida();
            Limpeza.limpeza();
            menuRegistro();
        }
    }

    //Menu de Registro
    public static void menuRegistro() throws InterruptedException{
        System.out.println("Menu de Registro\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] se Registrar como cliente");
        System.out.println("[2] se Registrar como Funcionário");
        System.out.println("[3] retornar ao menu anterior\n");

        try{
            System.out.print("--> ");
            int escolha = sc.nextInt();
            Limpeza.limpeza();
            switch (escolha) {
                case 1:
                    CadastroCliente.cadastroCliente();
                    break;
                case 2:
                    CadastroFuncionario.cadastroFuncionario();
                    break;
                case 3:
                    menu();
                    break;
                default:
                    sc.nextLine();
                    tratamento.opcaoInvalida();
                    Limpeza.limpeza();
                    menuRegistro();
                    break;
            }
        } catch (Exception e) {
                sc.nextLine();
                tratamento.opcaoInvalida();
                Limpeza.limpeza();
                menuRegistro();
        }
    }

        //Start no APP
        public static void main(String[] args) throws InterruptedException {
            menu();
        }
        
    }