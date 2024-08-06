package com.healthPharmacy.service;

import com.healthPharmacy.Tratamento.tratamento;
import com.healthPharmacy.model.Cliente;
import com.healthPharmacy.model.Funcionario;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.healthPharmacy.repository.FuncionarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findByCpf(String cpf) {
        return funcionarioRepository.findById(Long.valueOf(cpf));
    }



    public static void adicionarFuncionario() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adicionar Funcionario\n");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        System.out.print("CPF: ");
        String CPF = sc.nextLine();
        CPF = CPF.replaceAll("[^0-9]", "");
        if (CPF.length() != 11) {
            tratamento.CPFInvalido();
            MenuAdm.menuADM();
        }

        try {
            Funcionario funcionarioExistente = em.createQuery("SELECT f FROM Funcionario f WHERE f.CPF = :CPF", Funcionario.class).setParameter("CPF", CPF).getSingleResult();
            tratamento.contaJaExiste();
            em.close();
            emf.close();
            MenuAdm.menuADM();
        } catch (NoResultException e) {
            // Funcionário não encontrado, pode prosseguir com o cadastro
        }
        System.out.print("Nome: ");
        String nome = sc.nextLine();
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
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        Funcionario funcionario = new Funcionario(nome, email, telefone, cargo, senha, CPF);
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        System.out.println("Funcionario adicionado com sucesso!");
        em.close();
        emf.close();
        Thread.sleep(2000);
        MenuAdm.menuADM();

    }

}
