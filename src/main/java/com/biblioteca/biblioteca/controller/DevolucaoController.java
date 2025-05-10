package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.DevolucaoDTO;
import com.biblioteca.biblioteca.interfacce.IDevolucaoService;
import com.biblioteca.biblioteca.model.Emprestimo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devolucao")
public class DevolucaoController {

    private final IDevolucaoService devolucaoService;

    public DevolucaoController(IDevolucaoService devolucaoService) {
        this.devolucaoService = devolucaoService;
    }

    @PostMapping("/registrar")
    @Operation(summary = "Registrar a devolução de um livro", description = """
            <h3>Condições para registrar uma devolução: </h3>
            <li> O empréstimo deve existir </li>
            <li> O livro não deve ter sido devolvido anteriormente </li>
            <li> O livro deve existir no sistema </li>
            """)
    public ResponseEntity<Emprestimo> registrarDevolucao(@RequestBody DevolucaoDTO devolucaoDTO) {
        Emprestimo emprestimo = devolucaoService.registrarDevolucao(devolucaoDTO);
        return ResponseEntity.ok(emprestimo);
    }
} 