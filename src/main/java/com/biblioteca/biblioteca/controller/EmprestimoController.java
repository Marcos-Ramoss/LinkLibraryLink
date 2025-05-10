package com.biblioteca.biblioteca.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.dto.EmprestimoDTO;
import com.biblioteca.biblioteca.interfacce.IEmprestimoService;
import com.biblioteca.biblioteca.model.Emprestimo;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final IEmprestimoService emprestimoService;

    public EmprestimoController(IEmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/cadastrar/emprestimo")
    public ResponseEntity<Emprestimo> registrarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = emprestimoService.registrarEmprestimo(emprestimoDTO);
        return new ResponseEntity<>(emprestimo, HttpStatus.CREATED);
    }

    @GetMapping("buscar/emprestimo/usuario/{idUsuario}")
    public ResponseEntity<List<Emprestimo>> listarPorUsuario(@PathVariable("idUsuario") String idUsuario) {
        return ResponseEntity.ok(emprestimoService.listarEmprestimosPorUsuario(idUsuario));
    }

    @GetMapping("buscar/emprestimo/livro/{idLivro}")
    public ResponseEntity<List<Emprestimo>> listarPorLivro(@PathVariable("idLivro") String idLivro) {
        return ResponseEntity.ok(emprestimoService.listarEmprestimosPorLivro(idLivro));
    }
}