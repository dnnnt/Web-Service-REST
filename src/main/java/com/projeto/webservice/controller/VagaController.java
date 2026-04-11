package com.projeto.webservice.controller;

import com.projeto.webservice.model.Vaga;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private List<Vaga> vagas = new ArrayList<>();

    public VagaController() {
        vagas.add(new Vaga(1L, "Desenvolvedor Java", "Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.", LocalDate.parse("2025-10-01"), true, 1L));
        vagas.add(new Vaga(2L, "Analista de Suporte Técnico", "Suporte a clientes, resolução de chamados e participação em treinamentos internos.", LocalDate.parse("2025-09-27"), true, 2L));
        vagas.add(new Vaga(3L, "Engenheiro de Software", "Desenvolvimento de soluções para sistemas corporativos, integração e automação.", LocalDate.parse("2025-10-03"), false, 3L));
        vagas.add(new Vaga(4L, "Analista de Dados", "Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python.", LocalDate.parse("2025-09-18"), true, 4L));
        vagas.add(new Vaga(5L, "Designer Digital", "Criação de materiais gráficos, UX/UI e participação em campanhas de marketing.", LocalDate.parse("2025-09-30"), false, 5L));
        vagas.add(new Vaga(6L, "Consultor de Projetos", "Elaboração e acompanhamento de projetos empresariais e treinamentos.", LocalDate.parse("2025-10-06"), true, 1L));
        vagas.add(new Vaga(7L, "Programador Full Stack", "Desenvolvimento de aplicações web frontend e backend com foco em automação.", LocalDate.parse("2025-10-04"), true, 2L));
    }

    @GetMapping
    public List<Vaga> listar() { return vagas; }

    @GetMapping("/{id}")
    public Vaga buscarPorId(@PathVariable Long id) {
        return vagas.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Vaga criar(@RequestBody Vaga vaga) {
        vagas.add(vaga);
        return vaga;
    }

    @PutMapping("/{id}")
    public Vaga atualizar(@PathVariable Long id, @RequestBody Vaga vagaAtualizada) {
        for (int i = 0; i < vagas.size(); i++) {
            if (vagas.get(i).getId().equals(id)) {
                vagas.set(i, vagaAtualizada);
                return vagaAtualizada;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        vagas.removeIf(v -> v.getId().equals(id));
    }
}