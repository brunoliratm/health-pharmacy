package Servico;

import java.util.Scanner;

import Entidade.Funcionario;
import Entidade.Produto;
import GUI.MenuProdutos;
import Repositorio.RepositorioProduto;
import Tratamento.tratamento;

public class CadastroProduto {
    static Scanner sc = new Scanner(System.in);

    public static void cadastroProduto(Scanner sc) throws InterruptedException {
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
            sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            String tarja = tarja();

            Produto produtoo = new Produto(id, nome, preco, quantidade, marca, tarja);
            RepositorioProduto.addProduto(produtoo);
            System.out.println("Produto cadastrado");
            Thread.sleep(2000);

        } catch (Exception e) {
            tratamento.valorInvalido();
        }
    }

    public static String tarja() throws InterruptedException {
        String tarja = null;
        System.out.println("Qual a tarja do medicamento");
        System.out.println(" [1]-Sem tarja\n [2]-tarja amarela\n [3]-tarja vermelha\n [4]tarja preta");

        System.out.print("--> ");
        String escolha = sc.nextLine();
        switch (escolha) {
            case "1":
                tarja = "Sem tarja";
                break;
            case "2":
                tarja = "Tarja amarela";
                break;
            case "3":
                tarja = "Tarja vermelha";
                break;
            case "4":
                tarja = "Tarja preta";
                break;
            default:
                System.out.println("Digite uma opção válida!");
                tarja();

        }

        return tarja;

    }
}
