package Servico;

import java.util.Scanner;

import Entidade.Suplemento;
import Repositorio.SuplementoRepositorio;

public class SuplementoServico {
    public void cadastroSuplemento() throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCADASTRO DE SUPLEMENTO");
        Thread.sleep(1000);
        System.out.print("\nID: ");
        String idSuplemento = sc.nextLine();
        System.out.print("\nNome: ");
        String nomeSuplemento = sc.nextLine();
        System.out.print("\nPreço: ");
        float precoSuplemento = sc.nextFloat();
        System.out.print("\nQuantidade: ");
        int quantidadeSuplemento = sc.nextInt();
        System.out.print("\nMarca: ");
        String marcaSuplemento = sc.nextLine();
        Suplemento suplemento1 = new Suplemento(idSuplemento, nomeSuplemento, precoSuplemento, quantidadeSuplemento, marcaSuplemento);
        SuplementoRepositorio.addSuplemento(suplemento1); 
        sc.close();
    }
}
