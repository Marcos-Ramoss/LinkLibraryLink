package com.biblioteca.biblioteca.interfacce;

import com.biblioteca.biblioteca.dto.UsuarioDTO;
import com.biblioteca.biblioteca.model.Usuario;

public interface IUsuarioService {
    Usuario cadastrarUsuario(UsuarioDTO usuarioDTO);
    Usuario buscarPorMatricula(String matricula);
} 