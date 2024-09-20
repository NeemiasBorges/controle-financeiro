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

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente)
    {
        cliente.setId(nextId++);
        
        clientes.add(cliente);
        return cliente;
    }

    @GetMapping
    public List<Cliente> listarClientes() 
    {
        return clientes;
    }

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable int id)
    {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable int id,
    @RequestBody Cliente cliUpdate) 
    {
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
    public boolean removerCliente(@PathVariable int id)
    {
        return clientes.removeIf(c -> c.getId() == id);
    }
}