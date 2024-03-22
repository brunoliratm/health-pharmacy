package Servico;

import java.util.Scanner;

import Entidade.Higiene;
import Repositorio.HigieneRepositorio;


public class HigieneServico {
    public void cadastroHigiene() throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCADASTRO DE HIGIENE");
        Thread.sleep(1000);
        System.out.print("\nID: ");
        String idHigiene = sc.nextLine();
        System.out.print("\nNome: ");
        String nomeHigiene = sc.nextLine();
        System.out.print("\nPreço: ");
        float precoHigiene = sc.nextFloat();
        System.out.print("\nQuantidade: ");
        int quantidadeHigiene = sc.nextInt();
        System.out.print("\nMarca: ");
        String marcaHigiene= sc.nextLine();
        Higiene higiene1 = new Higiene(idHigiene, nomeHigiene, precoHigiene, quantidadeHigiene, marcaHigiene);
        HigieneRepositorio.addHigiene(higiene1); 
        sc.close();
    }
}
