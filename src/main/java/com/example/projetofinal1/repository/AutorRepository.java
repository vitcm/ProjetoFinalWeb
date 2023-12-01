package com.example.projetofinal1.repository;

import com.example.projetofinal1.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository <Autor,Long>{
}
