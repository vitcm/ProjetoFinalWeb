package com.example.projetofinal1.service;

import com.example.projetofinal1.model.Livro;
import com.example.projetofinal1.model.LivroDTO;
import com.example.projetofinal1.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarLivroPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void excluirLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public LivroDTO convertToDTO(Livro livro) {
        return new LivroDTO(livro);
    }

    public List<LivroDTO> convertToDTOList(List<Livro> livros) {
        return livros.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
