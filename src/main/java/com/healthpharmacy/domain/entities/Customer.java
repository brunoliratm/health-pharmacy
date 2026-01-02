package com.healthpharmacy.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

@Entity
public final class Customer extends Person {

    @Column(length = 3,nullable = false)
    private LocalDate birthDate;
    public Customer() {}

    public Customer(String cpf, String name, String email, String password, LocalDate birthDate) {
        super(cpf, name, email, password);
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
