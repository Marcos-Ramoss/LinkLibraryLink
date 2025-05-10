package com.biblioteca.biblioteca.dto;

public record LoginResponseDTO(
    String token,
    String nome,
    String email,
    String tipoUsuario
) {} 