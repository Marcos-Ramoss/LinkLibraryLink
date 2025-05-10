package com.biblioteca.biblioteca.dto;

import java.time.LocalDate;

public record EmprestimoDTO(
    String idUsuario,
    String idLivro,
    LocalDate dataEmprestimo,
    LocalDate dataDevolucaoPrevista
) {} 