package com.example.projetofinal1.controllers;

import com.example.projetofinal1.model.Autor;
import com.example.projetofinal1.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@RestController
@RequestMapping("/autores")
@Validated
public class AutorController {
    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.listarAutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Long id) {
        Autor autor = autorService.buscarAutorPorId(id).orElse(null);
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public ResponseEntity<Autor> salvarAutor(@RequestBody Autor autor) {
        // Faça a validação manual aqui, se necessário
        if (autor == null || autor.getNome() == null || autor.getNome().trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Autor autorSalvo = autorService.salvarAutor(autor);
        return new ResponseEntity<>(autorSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAutor(@PathVariable Long id) {
        autorService.excluirAutor(id);
        return ResponseEntity.noContent().build();
    }
}
