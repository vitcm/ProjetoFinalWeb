package com.example.projetofinal1.service;

import com.example.projetofinal1.model.Autor;
import com.example.projetofinal1.model.AutorDTO;
import com.example.projetofinal1.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarAutorPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void excluirAutor(Long id) {
        autorRepository.deleteById(id);
    }

    public AutorDTO convertToDTO(Autor autor) {
        return new AutorDTO(autor);
    }

    public List<AutorDTO> convertToDTOList(List<Autor> autores) {
        return autores.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
