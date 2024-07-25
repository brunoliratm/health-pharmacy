package com.healthPharmacy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDTO (@NotBlank String nome,
                          @NotBlank String email,
                          @NotNull Integer idade,
                          @NotNull @NotBlank String endereco,
                          @NotBlank String telefone,
                          @NotNull String senha,
                          @NotNull @NotBlank String CPF){
}
