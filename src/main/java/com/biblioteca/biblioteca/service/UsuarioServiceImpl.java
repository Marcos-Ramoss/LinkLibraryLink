package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.dto.UsuarioDTO;
import com.biblioteca.biblioteca.enumeration.TipoUsuario;
import com.biblioteca.biblioteca.interfacce.IUsuarioService;
import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.findByMatricula(usuarioDTO.matricula()).isPresent()) {
            throw new DataIntegrityViolationException("Matrícula já cadastrada");
        }
        if (usuarioRepository.findByEmail(usuarioDTO.email()).isPresent()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado");
        }
        Usuario usuario = Usuario.builder()
                .nome(usuarioDTO.nome())
                .matricula(usuarioDTO.matricula())
                .email(usuarioDTO.email())
                .tipoUsuario(TipoUsuario.valueOf(usuarioDTO.tipoUsuario().toUpperCase()))
                .build();
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorMatricula(String matricula) {
        return usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}