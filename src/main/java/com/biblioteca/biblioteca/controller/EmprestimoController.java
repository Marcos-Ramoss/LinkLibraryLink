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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final IEmprestimoService emprestimoService;

    public EmprestimoController(IEmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/cadastrar/emprestimo")
    @Operation(summary = "Registrar um novo empréstimo", description = """
            <h3>Preencha todos os campos obrigatórios </h3>
            <li> Tabela: Emprestimo </li>
            """)
    public ResponseEntity<Emprestimo> registrarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = emprestimoService.registrarEmprestimo(emprestimoDTO);
        return new ResponseEntity<>(emprestimo, HttpStatus.CREATED);
    }

    @GetMapping("buscar/emprestimo/usuario/{idUsuario}")
    @Operation(summary = "Listar empréstimos por usuário", description = """
            <h3>Condições para listar empréstimos por usuário: </h3>
            <li> informar o valor idUsuario</li>
            <li> Tabela: Emprestimo </li>
            """)
    public ResponseEntity<List<Emprestimo>> listarPorUsuario(@PathVariable("idUsuario") String idUsuario) {
        return ResponseEntity.ok(emprestimoService.listarEmprestimosPorUsuario(idUsuario));
    }

    @GetMapping("buscar/emprestimo/livro/{idLivro}")
    @Operation(summary = "Listar empréstimos por livro", description = """
            <h3>Condições para listar empréstimos por livro: </h3>
            <li> informar o valor idLivro</li>
            <li> Tabela: Emprestimo </li>
            """)
    public ResponseEntity<List<Emprestimo>> listarPorLivro(@PathVariable("idLivro") String idLivro) {
        return ResponseEntity.ok(emprestimoService.listarEmprestimosPorLivro(idLivro));
    }
}