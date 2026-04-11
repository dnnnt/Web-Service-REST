package com.projeto.webservice.model;

public class Empresa {
    private Long id;
    private String nome;
    private String cnpj;
    private String emailContato;

    public Empresa(Long id, String nome, String cnpj, String emailContato) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.emailContato = emailContato;
    }
    
}