package com.healthPharmacy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(length = 50)
    private String cargo;
    @Id
    @Column(length = 11)
    private String CPF;

    public Funcionario(){
    }
    
    public Funcionario(String nome,String email,String telefone,String cargo, String senha, String CPF){
        super(nome, telefone, email, senha);
        this.cargo = cargo;
        this.CPF = CPF;
    }


    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }


    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nCargo: " + getCargo() + "\nCPF: " + getCPF() + "\nTelefone: " + getTelefone() + "\nEmail: " + getEmail() + "\nSenha: " + getSenha()+ "\n";
    }

    
}
