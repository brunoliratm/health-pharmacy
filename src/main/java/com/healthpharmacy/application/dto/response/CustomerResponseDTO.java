package com.healthpharmacy.application.dto.response;

public record CustomerResponseDTO(
        String cpf,
        String name,
        String email,
        int age
) {
}
