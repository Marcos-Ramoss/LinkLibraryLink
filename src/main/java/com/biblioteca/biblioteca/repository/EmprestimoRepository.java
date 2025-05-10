package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Emprestimo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EmprestimoRepository extends MongoRepository<Emprestimo, String> {
    List<Emprestimo> findByIdUsuario(String idUsuario);
    List<Emprestimo> findByIdLivro(String idLivro);
} 