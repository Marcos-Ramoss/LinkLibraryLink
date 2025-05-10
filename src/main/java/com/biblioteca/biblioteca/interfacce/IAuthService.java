package com.biblioteca.biblioteca.interfacce;

import com.biblioteca.biblioteca.dto.LoginRequestDTO;
import com.biblioteca.biblioteca.dto.LoginResponseDTO;

public interface IAuthService {
    LoginResponseDTO autenticar(LoginRequestDTO loginRequestDTO);
} 