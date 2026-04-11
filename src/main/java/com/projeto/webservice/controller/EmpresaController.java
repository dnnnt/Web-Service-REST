package com.projeto.webservice.controller;

import com.projeto.webservice.model.Empresa;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private List<Empresa> empresas = new ArrayList<>();

    public EmpresaController() {
        empresas.add(new Empresa(1L, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
        empresas.add(new Empresa(2L, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
        empresas.add(new Empresa(3L, "Gamma Serviços S.A.", "11.222.333/0001-44", "servicos@gamma.com"));
        empresas.add(new Empresa(4L, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
        empresas.add(new Empresa(5L, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
    }

    @GetMapping
    public List<Empresa> listar() {
        return empresas;
    }

    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable Long id) {
        return empresas.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Empresa criar(@RequestBody Empresa empresa) {
        empresas.add(empresa);
        return empresa;
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa empresaAtualizada) {
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId().equals(id)) {
                empresas.set(i, empresaAtualizada);
                return empresaAtualizada;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        empresas.removeIf(e -> e.getId().equals(id));
    }
}