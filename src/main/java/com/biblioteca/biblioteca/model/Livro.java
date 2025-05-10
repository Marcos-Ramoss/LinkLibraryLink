package com.biblioteca.biblioteca.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "livros")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {
    @Id
    private String id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    private String isbn;
    private Integer quantidadeExemplares;
    private String categoria;
} 