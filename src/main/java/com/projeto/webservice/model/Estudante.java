package com.projeto.webservice.model;
import java.time.LocalDate;

public class Estudante {
    private Long id;
    private String nome;
    private String email;
    private LocalDate nascimento;
    private Integer anoIngresso;

    public Estudante(Long id, String nome, String email, LocalDate nascimento, Integer anoIngresso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.anoIngresso = anoIngresso;
    }

}