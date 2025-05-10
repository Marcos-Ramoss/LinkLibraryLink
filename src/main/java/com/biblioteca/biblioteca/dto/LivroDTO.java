package com.biblioteca.biblioteca.dto;

public record LivroDTO(
    String titulo,
    String autor,
    String editora,
    Integer ano,
    String isbn,
    Integer quantidadeExemplares,
    String categoria
) {} 