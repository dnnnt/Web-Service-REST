package com.projeto.webservice.controller;

import com.projeto.webservice.model.Estudante;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private List<Estudante> estudantes = new ArrayList<>();

    public EstudanteController() {
        estudantes.add(new Estudante(1L, "Ana Paula Souza", "ana.souza@email.com", LocalDate.parse("2002-03-15"), 2020));
        estudantes.add(new Estudante(2L, "Carlos Henrique Lima", "carlos.lima@email.com", LocalDate.parse("2001-10-22"), 2019));
        estudantes.add(new Estudante(3L, "Fernanda Oliveira", "fernanda.oliveira@email.com", LocalDate.parse("2003-07-05"), 2021));
        estudantes.add(new Estudante(4L, "Lucas Pereira", "lucas.pereira@email.com", LocalDate.parse("2002-04-11"), 2020));
        estudantes.add(new Estudante(5L, "Gabriela Martins", "gabriela.martins@email.com", LocalDate.parse("2001-12-25"), 2019));
        estudantes.add(new Estudante(6L, "Rafael Costa", "rafael.costa@email.com", LocalDate.parse("2000-09-13"), 2018));
        estudantes.add(new Estudante(7L, "Juliana Silva", "juliana.silva@email.com", LocalDate.parse("2002-06-18"), 2020));
        estudantes.add(new Estudante(8L, "Marcos Vinícius", "marcos.vinicius@email.com", LocalDate.parse("2003-01-30"), 2021));
        estudantes.add(new Estudante(9L, "Camila Azevedo", "camila.azevedo@email.com", LocalDate.parse("2001-11-08"), 2019));
        estudantes.add(new Estudante(10L, "Felipe Cardoso", "felipe.cardoso@email.com", LocalDate.parse("2000-08-27"), 2018));
    }

    @GetMapping
    public List<Estudante> listar() { return estudantes; }

    @GetMapping("/{id}")
    public Estudante buscarPorId(@PathVariable Long id) {
        return estudantes.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Estudante criar(@RequestBody Estudante estudante) {
        estudantes.add(estudante);
        return estudante;
    }

    @PutMapping("/{id}")
    public Estudante atualizar(@PathVariable Long id, @RequestBody Estudante estudanteAtualizado) {
        for (int i = 0; i < estudantes.size(); i++) {
            if (estudantes.get(i).getId().equals(id)) {
                estudantes.set(i, estudanteAtualizado);
                return estudanteAtualizado;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        estudantes.removeIf(e -> e.getId().equals(id));
    }
}