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
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 7c3994fedcd1aef1fa8a6d42bce6c10b3ff13ed9

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
<<<<<<< HEAD
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDto) {
        var clienteNovo = new Cliente();
        BeanUtils.copyProperties(clienteDto, clienteNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastrarCliente(clienteNovo));
    }
    @PutMapping("/atualizarCliente/{cpf}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable(value = "cpf") String cpf, @RequestBody @Valid ClienteDTO clienteDto){
        Optional<Cliente> cliente = clienteService.findByCpf(cpf);
        if (cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        var clienteModel = cliente.get();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.cadastrarCliente(clienteModel));
    }

=======
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid ClienteDTO cliente) {
        var clienteNovo = new Cliente();
        BeanUtils.copyProperties(cliente, clienteNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastrarCliente(clienteNovo));
    }
>>>>>>> 7c3994fedcd1aef1fa8a6d42bce6c10b3ff13ed9
}