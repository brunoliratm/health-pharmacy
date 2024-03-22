package Servico;

import java.util.Scanner;

import Entidade.Medicamento;
import Repositorio.MedicamentoRepositorio;
import TratamentoDeErroELimpeza.tratamento;

public class MedicamentoSevico {
    Scanner sc = new Scanner(System.in);
    public void cadastroMedicamento() throws InterruptedException{
        System.out.println("\nCADASTRO DE MEDICAMENTO");
        Thread.sleep(1000);
        System.out.print("\nID: ");
        String idMedicamento = sc.nextLine();
        System.out.print("\nNome: ");
        String nomeMedicamento = sc.nextLine();
        System.out.print("\nPreço: ");
        float precoMedicamento = sc.nextFloat();
        System.out.print("\nQuantidade: ");
        int quantidadeMedicamento = sc.nextInt();
        System.out.print("\nMarca: ");
        String marcaMedicamento = sc.nextLine();
        String tarja = tarja();
        
        Medicamento medicamento1 = new Medicamento(idMedicamento, nomeMedicamento, precoMedicamento, quantidadeMedicamento, marcaMedicamento, tarja);
        MedicamentoRepositorio.addMedicamento(medicamento1);
       System.out.println("Medicamento cadastrado");
       sc.close();
    }

    public String tarja(){
        boolean condition = false;
        String tarja = null; 
        while (condition==false) {
            System.out.println("Qual a tarja do medicamento");
            System.out.println("[1]-Sem tarja\n [2]-tarja amarela\n [3]-tarja vermelha\n [4]tarja preta");
            int escolha = sc.nextInt();
            try{
                switch(escolha){
                    case 1: 
                        tarja = "Sem tarja";
                        break;
                    case 2:
                        tarja = "Tarja amarela";
                        break;
                        case 3: 
                        tarja = "Tarja vermelha";
                        break;
                    case 4: 
                        tarja = "Tarja preta";
                        break;
                    }
                condition= true;
                
            }catch(Exception e){
                tratamento.opçãoInvalida();
            }
        }
        return tarja;
    
    }

}



