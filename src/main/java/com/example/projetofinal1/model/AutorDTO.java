package com.example.projetofinal1.model;

import lombok.Data;
public class AutorDTO {
    private Long id;
    private String nome;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
    }
}
