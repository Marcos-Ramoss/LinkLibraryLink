package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.dto.LoginRequestDTO;
import com.biblioteca.biblioteca.dto.LoginResponseDTO;
import com.biblioteca.biblioteca.interfacce.IAuthService;
import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.repository.UsuarioRepository;
import com.biblioteca.biblioteca.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthServiceImpl(UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponseDTO autenticar(LoginRequestDTO loginRequestDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginRequestDTO.email())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(loginRequestDTO.senha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtUtil.generateToken(usuario.getId(), usuario.getEmail(), usuario.getTipoUsuario().name());

        return new LoginResponseDTO(
            token,
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getTipoUsuario().name()
        );
    }
} 