package Servico;

import java.util.Scanner;

public class Menu  {
    
    public static void main(String[] args) throws InterruptedException {
        FuncionarioServico f1 = new FuncionarioServico();
        System.out.println("    HEALTH  PHARMACY\n");
        Thread.sleep(2000);
        int loop = 0;
        while (loop!=3) {
                
            System.out.println("Digite o número da opção desejada:\n");
            System.out.println("[1] Logar");
            System.out.println("[2] Se Registrar");
            System.out.println("[3] Sair do Aplicativo");

            Scanner sc = new Scanner(System.in);
            try{
                
                int escolha = sc.nextInt();
                switch (escolha){
                    case 1: 

                        System.out.println("Cadastro como funcionario");
                        Thread.sleep(1000);
                        f1.cadastroFuncionario();
                        main(args);
                        break;
                    case 2:
                        menuRegistro();
                        break;
                    case 3:
                        loop=3;
                        break;
                }
                
            }catch(Exception e){
                sc.nextLine();
                System.out.println("opção inválida!, tente novamente.");
                main(args);
            }
            sc.close();
        }
    }
    public static void menuLogin(){
        
    }

    public static void menuRegistro() throws InterruptedException{
        System.out.println("Menu de Registro\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] se Registrar como cliente");
        System.out.println("[2] se Registrar como Funcionário");
        System.out.println("[3] retornar ao menu Inicial");
        Scanner sc = new Scanner(System.in);

        try {
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("digite uma opção válida!");
            
        }
        sc.close();
    }



}
