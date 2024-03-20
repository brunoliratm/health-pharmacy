package Servico;

import java.util.Scanner;

public class Menu  {
    
    public static void main(String[] args) {

        Scanner inputMain = new Scanner(System.in);
        try{
            System.out.println("    HEALTH   PHARMACY");
            System.out.println("Como você deseja se cadastrar");
            System.out.println("[1]-Funcionário");
            int escolha = inputMain.nextInt();
            switch (escolha){
                case 1: 
                System.out.println("Cadastro como funcionario");
                FuncionarioServico f1 = new FuncionarioServico();
                f1.cadastro();
                System.out.println("Concluido");
            }
            
        }finally{
            System.out.println("Cadastrado finalizado");
        }
    
}
    
    
}
