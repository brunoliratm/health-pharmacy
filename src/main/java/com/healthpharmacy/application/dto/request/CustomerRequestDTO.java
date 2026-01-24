package com.healthpharmacy.application.dto.request;

import java.time.LocalDate;

public record CustomerRequestDTO(
    String cpf,
    String name,
    String password,
    String email,
    LocalDate birthDate) {
}
