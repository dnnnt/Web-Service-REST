package com.projeto.webservice.controller;

import com.projeto.webservice.model.Estudante;
import com.projeto.webservice.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteRepository repository;

    @GetMapping
    public List<Estudante> listar() { 
        return repository.findAll(); 
    }

    @GetMapping("/{id}")
    public Estudante buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Estudante criar(@RequestBody Estudante estudante) {
        return repository.save(estudante);
    }

    @PutMapping("/{id}")
    public Estudante atualizar(@PathVariable Long id, @RequestBody Estudante estudanteAtualizado) {
        return repository.findById(id).map(estudante -> {
            estudante.setNome(estudanteAtualizado.getNome());
            estudante.setEmail(estudanteAtualizado.getEmail());
            estudante.setNascimento(estudanteAtualizado.getNascimento());
            estudante.setAnoIngresso(estudanteAtualizado.getAnoIngresso());
            return repository.save(estudante);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
