package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.dto.LivroDTO;
import com.biblioteca.biblioteca.interfacce.ILivroService;
import com.biblioteca.biblioteca.model.Livro;
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
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.cadastrarLivro(livroDTO);
        return new ResponseEntity<>(livro, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/livro/{isbn}")
    public ResponseEntity<Livro> buscarPorIsbn(@PathVariable String isbn) {
        Livro livro = livroService.buscarPorIsbn(isbn);
        return ResponseEntity.ok(livro);
    }

    @GetMapping("/buscar/titulo/{titulo}")
    public ResponseEntity<List<Livro>> buscarPorTitulo(@PathVariable("titulo") String titulo) {
        return ResponseEntity.ok(livroService.buscarPorTitulo(titulo));
    }

    @GetMapping("/buscar/autor/{autor}")
    public ResponseEntity<List<Livro>> buscarPorAutor(@PathVariable("autor") String autor) {
        return ResponseEntity.ok(livroService.buscarPorAutor(autor));
    }

    @GetMapping("/buscar/categoria/{categoria}")
    public ResponseEntity<List<Livro>> buscarPorCategoria(@PathVariable("categoria") String categoria) {
        return ResponseEntity.ok(livroService.buscarPorCategoria(categoria));
    }
} 