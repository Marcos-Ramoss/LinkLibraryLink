package com.biblioteca.biblioteca.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.biblioteca.biblioteca.dto.DevolucaoDTO;
import com.biblioteca.biblioteca.interfacce.IDevolucaoService;
import com.biblioteca.biblioteca.model.Emprestimo;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.EmprestimoRepository;
import com.biblioteca.biblioteca.repository.LivroRepository;
import com.biblioteca.biblioteca.repository.UsuarioRepository;

@Service
public class DevolucaoServiceImpl implements IDevolucaoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public DevolucaoServiceImpl(
            EmprestimoRepository emprestimoRepository,
            LivroRepository livroRepository,
            UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public Emprestimo registrarDevolucao(DevolucaoDTO devolucaoDTO) {
       
        Emprestimo emprestimo = emprestimoRepository.findById(devolucaoDTO.emprestimoId())
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        if (emprestimo.getDataDevolucao() != null) {
            throw new RuntimeException("Este livro já foi devolvido");
        }

        Livro livro = livroRepository.findById(devolucaoDTO.livroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livro.setDisponivel(true);
        livroRepository.save(livro);

        
        emprestimo.setDataDevolucao(LocalDate.now());
        
        return emprestimoRepository.save(emprestimo);
    }
} 