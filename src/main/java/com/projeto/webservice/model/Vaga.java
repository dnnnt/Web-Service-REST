package com.projeto.webservice.model;
import java.time.LocalDate;

public class Vaga {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate publicacao;
    private boolean ativo;
    private Long idEmpresa;

    public Vaga(Long id, String titulo, String descricao, LocalDate publicacao, boolean ativo, Long idEmpresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.publicacao = publicacao;
        this.ativo = ativo;
        this.idEmpresa = idEmpresa;
    }

}