package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.UsuarioDTO;
import com.biblioteca.biblioteca.interfacce.IUsuarioService;
import com.biblioteca.biblioteca.model.Usuario;

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
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.cadastrarUsuario(usuarioDTO);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Usuario> buscarPorMatricula(@PathVariable String matricula) {
        Usuario usuario = usuarioService.buscarPorMatricula(matricula);
        return ResponseEntity.ok(usuario);
    }
} 