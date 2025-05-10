package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.LivroDTO;
import com.biblioteca.biblioteca.interfacce.ILivroService;
import com.biblioteca.biblioteca.model.Livro;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final ILivroService livroService;

    public LivroController(ILivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/cadastrar/livro")
    @Operation(summary = "Cadastrar um novo livro", description = """
            <h3>Preencha todos os campos obrigatórios </h3>
            <li> Tabela: Livro </li>
            """)
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.cadastrarLivro(livroDTO);
        return new ResponseEntity<>(livro, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/livro/{isbn}")
    @Operation(summary = "Buscar um livro por ISBN", description = """
            <h3>Condições para buscar um livro por ISBN: </h3>
            <li> informar o valor isbn</li>
            <li> Tabela: Livro </li>
            """)
    public ResponseEntity<Livro> buscarPorIsbn(@PathVariable String isbn) {
        Livro livro = livroService.buscarPorIsbn(isbn);
        return ResponseEntity.ok(livro);
    }

    @GetMapping("/buscar/titulo/{titulo}")
    @Operation(summary = "Buscar um livro por titulo", description = """
            <h3>Condições para buscar um livro por titulo: </h3>
            <li> informar o valor titulo</li>
            <li> Tabela: Livro </li>
            """)
    public ResponseEntity<List<Livro>> buscarPorTitulo(@PathVariable("titulo") String titulo) {
        return ResponseEntity.ok(livroService.buscarPorTitulo(titulo));
    }

    @GetMapping("/buscar/autor/{autor}")
    @Operation(summary = "Buscar um livro por autor", description = """
            <h3>Condições para buscar um livro por autor: </h3>
            <li> informar o valor autor</li>
            <li> Tabela: Livro </li>
            """)
    public ResponseEntity<List<Livro>> buscarPorAutor(@PathVariable("autor") String autor) {
        return ResponseEntity.ok(livroService.buscarPorAutor(autor));
    }

    @GetMapping("/buscar/categoria/{categoria}")
    @Operation(summary = "Buscar um livro por categoria", description = """
            <h3>Condições para buscar um livro por categoria: </h3>
            <li> informar o valor categoria</li>
            <li> Tabela: Livro </li>
            """)
    public ResponseEntity<List<Livro>> buscarPorCategoria(@PathVariable("categoria") String categoria) {
        return ResponseEntity.ok(livroService.buscarPorCategoria(categoria));
    }
}