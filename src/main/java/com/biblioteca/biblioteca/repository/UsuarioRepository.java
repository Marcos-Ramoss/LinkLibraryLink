package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByMatricula(String matricula);
    Optional<Usuario> findByEmail(String email);
} 