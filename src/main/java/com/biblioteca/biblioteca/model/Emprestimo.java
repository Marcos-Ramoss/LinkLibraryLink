package com.biblioteca.biblioteca.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Document(collection = "emprestimos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emprestimo {
    @Id
    private String id;
    private String idUsuario;
    private String idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
} 