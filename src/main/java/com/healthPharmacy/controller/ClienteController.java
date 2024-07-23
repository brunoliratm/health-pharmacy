package com.healthPharmacy.controller;

import com.healthPharmacy.dto.ClienteDTO;
import com.healthPharmacy.model.Cliente;
import com.healthPharmacy.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }
    @PostMapping("/cadastrarCliente")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid ClienteDTO cliente) {
        var clienteNovo = new Cliente();
        BeanUtils.copyProperties(cliente, clienteNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastrarCliente(clienteNovo));
    }
}