package Servico;

import java.util.Scanner;

import Entidade.Produto;
import Repositorio.RepositorioProduto;
import Tratamento.tratamento;

public class CadastroProduto {
    Scanner sc = new Scanner(System.in);

    public void cadastroProduto() throws InterruptedException {
        System.out.println("Cadastrar novo Produto: \n");
        Thread.sleep(1000);

        try {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Preço: ");
            float preco = sc.nextFloat();
            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            String tarja = tarja();

            Produto produtoo = new Produto(id, nome, preco, quantidade, marca, tarja);
            RepositorioProduto.addProduto(produtoo);
            System.out.println("Produto cadastrado");
            sc.close();
        } catch (Exception e) {
            tratamento.valorInvalido();
            cadastroProduto();
        }
    }

    public String tarja() throws InterruptedException {
        String tarja = null;
        System.out.println("Qual a tarja do medicamento");
        System.out.println("[1]-Sem tarja\n [2]-tarja amarela\n [3]-tarja vermelha\n [4]tarja preta");

        System.out.print("--> ");
        String escolha = sc.nextLine();
        switch (escolha) {
            case "1":
                tarja = "Sem tarja";
            case "2":
                tarja = "Tarja amarela";
            case "3":
                tarja = "Tarja vermelha";
            case "4":
                tarja = "Tarja preta";
            default:
                System.out.println("Digite uma opção válida!");
                tarja();
        }

        return tarja;

    }
}
