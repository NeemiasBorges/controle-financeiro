package com.fatec.controle_financeiro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fatec.controle_financeiro.entities.Cliente;
import com.fatec.domain.cliente.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    private List<Cliente> clientes = new ArrayList<>();

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        try {
            clienteRepository.save(cliente);

        } catch (Exception e) {
            return null;
        }
        return cliente;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        try {
            return clienteRepository.findAll();

        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable int id) {
        return clienteRepository.getById(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable int id,
            @RequestBody Cliente cliUpdate) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getId() == id) {
                cliUpdate.setId(id);
                clientes.set(i, cliUpdate);
                return cliUpdate;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean removerCliente(@PathVariable int id) {

        try {
            Cliente cCliente = obterCliente(id);
            clienteRepository.delete(cCliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}