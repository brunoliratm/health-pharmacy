package com.healthpharmacy.application.dto.request;

import java.time.LocalDate;

public record CustomerUpdateRequestDTO(
    String name,
    String password,
    String email,
    LocalDate birthDate) {
}
