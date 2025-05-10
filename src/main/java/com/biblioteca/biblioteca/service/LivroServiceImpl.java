package com.biblioteca.biblioteca.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.biblioteca.biblioteca.dto.LivroDTO;
import com.biblioteca.biblioteca.interfacce.ILivroService;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;
import java.util.List;

@Service
public class LivroServiceImpl implements ILivroService {

    private final LivroRepository livroRepository;

    public LivroServiceImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public Livro cadastrarLivro(LivroDTO livroDTO) {
        if (livroRepository.findByIsbn(livroDTO.isbn()).isPresent()) {
            throw new DataIntegrityViolationException("ISBN já cadastrado");
        }
        Livro livro = Livro.builder()
                .titulo(livroDTO.titulo())
                .autor(livroDTO.autor())
                .editora(livroDTO.editora())
                .ano(livroDTO.ano())
                .isbn(livroDTO.isbn())
                .quantidadeExemplares(livroDTO.quantidadeExemplares())
                .build();
        return livroRepository.save(livro);
    }

    @Override
    public Livro buscarPorIsbn(String isbn) {
        return livroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    @Override
    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Livro> buscarPorAutor(String autor) {
        return livroRepository.findByAutorContainingIgnoreCase(autor);
    }

    @Override
    public List<Livro> buscarPorCategoria(String categoria) {
        return livroRepository.findByCategoriaContainingIgnoreCase(categoria);
    }
}