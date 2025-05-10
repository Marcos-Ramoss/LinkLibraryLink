package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.UsuarioDTO;
import com.biblioteca.biblioteca.interfacce.IUsuarioService;
import com.biblioteca.biblioteca.model.Usuario;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar/usuarios")
    @Operation(summary = "Cadastrar um novo usuário", description = """
            <h3>Preencha todos os campos obrigatórios </h3>
            <li> Tabela: Usuario </li>
            """)
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.cadastrarUsuario(usuarioDTO);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/{matricula}")
    @Operation(summary = "Buscar um usuário por matrícula", description = """
            <h3>Condições para buscar um usuário por matrícula: </h3>
            <li> informar o valor matricula</li>
            <li> Tabela: Usuario </li>
            """)
    public ResponseEntity<Usuario> buscarPorMatricula(@PathVariable("matricula") String matricula) {
        Usuario usuario = usuarioService.buscarPorMatricula(matricula);
        return ResponseEntity.ok(usuario);
    }
}