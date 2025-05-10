package com.biblioteca.biblioteca.interfacce;

import com.biblioteca.biblioteca.dto.LivroDTO;
import com.biblioteca.biblioteca.model.Livro;
import java.util.List;

public interface ILivroService {
    Livro cadastrarLivro(LivroDTO livroDTO);
    Livro buscarPorIsbn(String isbn);
    List<Livro> buscarPorTitulo(String titulo);
    List<Livro> buscarPorAutor(String autor);
    List<Livro> buscarPorCategoria(String categoria);
} 