package com.healthpharmacy.domain.entities;

import org.hibernate.annotations.Where;
import javax.persistence.*;

@Entity
@Where(clause = "active= true")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public sealed abstract class Person permits Customer{
    @Id
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(length = 100,  nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean active = true;

    public Person(){}

    public Person(String cpf, String name, String email, String password) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
