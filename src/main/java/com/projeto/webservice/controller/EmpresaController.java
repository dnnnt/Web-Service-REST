package com.projeto.webservice.controller;

import com.projeto.webservice.model.Empresa;
import com.projeto.webservice.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public List<Empresa> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Empresa criar(@RequestBody Empresa empresa) {
        return repository.save(empresa);
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa empresaAtualizada) {
        return repository.findById(id).map(empresa -> {
            empresa.setNome(empresaAtualizada.getNome());
            empresa.setCnpj(empresaAtualizada.getCnpj());
            empresa.setEmailContato(empresaAtualizada.getEmailContato());
            return repository.save(empresa);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
