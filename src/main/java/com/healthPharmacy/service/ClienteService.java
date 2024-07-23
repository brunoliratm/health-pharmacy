package com.healthPharmacy.service;

import com.healthPharmacy.model.Cliente;
import com.healthPharmacy.Tratamento.tratamento;
import com.healthPharmacy.GUI.MenuCliente;
import com.healthPharmacy.GUI.MenuEntrada;

import com.healthPharmacy.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public static void cadastroCliente() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Cadastro de Cliente:\n");

        System.out.print("CPF: ");
        String CPF = sc.nextLine().replaceAll("[^0-9]", "");
        if (CPF.length() != 11) {
            tratamento.CPFInvalido();
            MenuEntrada.menuRegistro();
        }

        try {
            @SuppressWarnings("unused")
            Cliente clienteExistente = em.createQuery("SELECT c FROM Cliente c WHERE c.CPF = :CPF", Cliente.class)
                    .setParameter("CPF", CPF)
                    .getSingleResult();
            tratamento.contaJaExiste();
            em.close();
            emf.close();
            MenuEntrada.menuRegistro();
        } catch (NoResultException e) {
            // Cliente não encontrado, pode prosseguir com o cadastro
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Endereco: ");
        String endereco = sc.nextLine();
        int idade = 0;
            System.out.print("Idade: ");
            try {
                idade = Integer.parseInt(sc.nextLine().replaceAll("[^0-9]", ""));
                if (idade < 18) {
                    throw new IllegalArgumentException("Voce deve ter mais de 18 anos para se cadastrar.");
                }
            } catch (NumberFormatException e) {
                tratamento.valorInvalido();
                MenuEntrada.menuRegistro();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                Thread.sleep(2000);
                MenuEntrada.menuRegistro();
            }

        String telefone;
        while (true) {
            System.out.print("Telefone (ex: 8199999 9999): ");
            telefone = sc.nextLine().replaceAll("[^0-9]", "");

            if (telefone.length() != 11) {
                System.out.println("Telefone invalido. o telefone deve conter 11 dígitos.");
            } else {
                break;
            }
        }
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Cliente cliente = new Cliente(nome, email, idade, endereco, telefone, senha, CPF);
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        System.out.println("Cliente cadastrado com sucesso!");
        em.close();
        emf.close();
        Thread.sleep(2000);
        MenuCliente.menuCliente(cliente);
    }


    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }
}
