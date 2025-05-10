package com.biblioteca.biblioteca.dto;

public record UsuarioDTO(
    String nome,
    String matricula,
    String email,
    String tipoUsuario, // Deve ser igual ao nome do enum
    String senha
) {} 