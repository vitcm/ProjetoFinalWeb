package com.example.projetofinal1.model;

import lombok.Data;

@Data
public class LivroDTO {
    private Long id;
    private String titulo;
    private String isbn;
    private String nomeAutor;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.nomeAutor = livro.getAutor().getNome();
    }
}
