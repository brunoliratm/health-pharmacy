package com.healthPharmacy.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.healthPharmacy.model.Funcionario;
import com.healthPharmacy.model.Produto;
import com.healthPharmacy.Tratamento.tratamento;
import com.healthPharmacy.GUI.MenuProdutos;


public class CadastroProduto {

    public static void cadastroProduto(Funcionario funcionario) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Cadastrar novo Produto: \n");
        Thread.sleep(1000);

        System.out.print("ID do produto: ");
        Long id = sc.nextLong();

        Produto produtoExistente = em.find(Produto.class, id);
        if (produtoExistente != null) {
            System.out.println("Ja existe um produto com esse ID!");
            Thread.sleep(2000);
            em.close();
            emf.close();
            MenuProdutos.menuProdutos(funcionario);
            return;
        }
        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();

        float preco;
        while (true) {
            System.out.print("Preco: ");
            try {
                preco = sc.nextFloat();
                sc.nextLine();
                if (preco <= 0) {
                    throw new IllegalArgumentException("Preco deve ser maior que zero.");
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException e) {
                tratamento.valorInvalido();
                sc.nextLine();
            }
        }

        int quantidade;
        while (true) {
            System.out.print("Quantidade em estoque: ");
            try {
                quantidade = sc.nextInt();
                sc.nextLine();
                if (quantidade < 0) {
                    throw new IllegalArgumentException("Quantidade deve ser maior ou igual a zero.");
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Quantidade invalida. Digite um valor numérico inteiro nao negativo.");
                sc.nextLine();
            }
        }
        System.out.print("Marca: ");
        String marca = sc.nextLine();

        String tarja = tarja();

        Produto produto = new Produto(nome, preco, quantidade, marca, tarja);

        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
        } finally{
            em.close();
            emf.close();
            System.out.println("Pressione Enter para retornar ao menu anterior.");
            sc.nextLine();
            MenuProdutos.menuProdutos(funcionario);
        }
    }

    public static String tarja() {
        Scanner sc = new Scanner(System.in);
        String tarja = null;
        System.out.println("Qual a tarja do medicamento");
        System.out.println(" [1] Sem tarja\n [2] tarja amarela\n [3]-tarja vermelha\n [4] tarja preta");

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
