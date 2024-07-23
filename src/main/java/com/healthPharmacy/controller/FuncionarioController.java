package com.healthPharmacy.controller;

import com.healthPharmacy.model.Funcionario;
import com.healthPharmacy.service.AdicionarFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private AdicionarFuncionario adicionarFuncionarioService;

    @PostMapping
    public Funcionario adicionarFuncionario(@RequestBody Funcionario funcionario) {
        return adicionarFuncionarioService.adicionarFuncionario(funcionario.getNome(), funcionario.getEmail(), funcionario.getTelefone(), funcionario.getCargo(), funcionario.getSenha(), funcionario.getCPF());
    }
}
