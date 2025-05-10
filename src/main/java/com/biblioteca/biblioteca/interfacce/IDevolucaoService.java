package com.biblioteca.biblioteca.interfacce;

import com.biblioteca.biblioteca.dto.DevolucaoDTO;
import com.biblioteca.biblioteca.model.Emprestimo;

public interface IDevolucaoService {
    Emprestimo registrarDevolucao(DevolucaoDTO devolucaoDTO);
} 