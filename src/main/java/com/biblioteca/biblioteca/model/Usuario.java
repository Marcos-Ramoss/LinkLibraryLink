package com.biblioteca.biblioteca.model;

import com.biblioteca.biblioteca.enumeration.TipoUsuario;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    private String id;

    private String nome;
    private String matricula;
    private String email;
    private TipoUsuario tipoUsuario;
}
