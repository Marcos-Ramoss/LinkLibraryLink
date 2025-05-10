package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface LivroRepository extends MongoRepository<Livro, String> {
    Optional<Livro> findByIsbn(String isbn);
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
    List<Livro> findByAutorContainingIgnoreCase(String autor);
    List<Livro> findByCategoriaContainingIgnoreCase(String categoria);
} 