package com.projeto.webservice.controller;

import com.projeto.webservice.model.Vaga;
import com.projeto.webservice.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaRepository repository;

    @GetMapping
    public List<Vaga> listar() { 
        return repository.findAll(); 
    }

    @GetMapping("/{id}")
    public Vaga buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Vaga criar(@RequestBody Vaga vaga) {
        return repository.save(vaga);
    }

    @PutMapping("/{id}")
    public Vaga atualizar(@PathVariable Long id, @RequestBody Vaga vagaAtualizada) {
        return repository.findById(id).map(vaga -> {
            vaga.setTitulo(vagaAtualizada.getTitulo());
            vaga.setDescricao(vagaAtualizada.getDescricao());
            vaga.setPublicacao(vagaAtualizada.getPublicacao());
            vaga.setAtivo(vagaAtualizada.isAtivo());
            vaga.setIdEmpresa(vagaAtualizada.getIdEmpresa());
            return repository.save(vaga);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
