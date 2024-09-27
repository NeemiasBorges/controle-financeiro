package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.*;
import com.fatec.controle_financeiro.entities.Fornecedor;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    private List<Fornecedor> Fornecedors = new ArrayList<>();
    private int nextId = 1;

    @PostMapping
    public Fornecedor criarFornecedor(@RequestBody Fornecedor Fornecedor)
    {
        Fornecedor.setId(nextId++);
        
        Fornecedors.add(Fornecedor);
        return Fornecedor;
    }

    @GetMapping
    public List<Fornecedor> listarFornecedors() 
    {
        return Fornecedors;
    }

    @GetMapping("/{id}")
    public Fornecedor obterFornecedor(@PathVariable int id)
    {
        return Fornecedors.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Fornecedor atualizarFornecedor(@PathVariable int id,
    @RequestBody Fornecedor cliUpdate) 
    {
        for (int i = 0; i < Fornecedors.size(); i++) {
            Fornecedor c = Fornecedors.get(i);
            if (c.getId() == id) {
                cliUpdate.setId(id);
                Fornecedors.set(i, cliUpdate);
                return cliUpdate;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean removerFornecedor(@PathVariable int id)
    {
        return Fornecedors.removeIf(c -> c.getId() == id);
    }
}