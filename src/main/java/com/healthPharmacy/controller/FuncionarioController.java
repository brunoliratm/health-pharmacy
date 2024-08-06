package com.healthPharmacy.controller;

import com.healthPharmacy.dto.ClienteDTO;
import com.healthPharmacy.dto.FuncionarioDTO;
import com.healthPharmacy.model.Cliente;
import com.healthPharmacy.model.Funcionario;
import com.healthPharmacy.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarTodosClientes() {
        return funcionarioService.listarTodosFuncionarios();
    }

    @PostMapping("/cadastrarFuncionario")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDto) {
        var funcionarioNovo = new Funcionario();
        BeanUtils.copyProperties(funcionarioDto, funcionarioNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.cadastrarFuncionario(funcionarioNovo));
    }

    @PutMapping("/atualizarFuncionario/{cpf}")
    public ResponseEntity<Object> atualizarFuncionario(@PathVariable(value = "cpf") String cpf, @RequestBody @Valid FuncionarioDTO funcionarioDto) {
        Optional<Funcionario> funcionario = funcionarioService.findByCpf(cpf);
        if (funcionario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado");
        }
        var funcionarioModel = funcionario.get();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.cadastrarFuncionario(funcionarioModel));
    }

}
