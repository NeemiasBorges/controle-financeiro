package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.*;
import com.fatec.controle_financeiro.entities.Cliente;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClientController {

    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;

    // Create (POST)
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    // Read (GET) - Listar todos os clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clientes;
    }

    // Read (GET) - Obter um cliente específico por id
    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable int id) {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update (PUT)
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable int id, @RequestBody Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getId() == id) {
                clienteAtualizado.setId(id);
                clientes.set(i, clienteAtualizado);
                return clienteAtualizado;
            }
        }
        return null;
    }

    // Delete (DELETE)
    @DeleteMapping("/{id}")
    public boolean removerCliente(@PathVariable int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }
}