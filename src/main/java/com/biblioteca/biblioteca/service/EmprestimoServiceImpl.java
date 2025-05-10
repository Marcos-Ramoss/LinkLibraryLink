package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.dto.EmprestimoDTO;
import com.biblioteca.biblioteca.interfacce.IEmprestimoService;
import com.biblioteca.biblioteca.model.Emprestimo;
import com.biblioteca.biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmprestimoServiceImpl implements IEmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    @Autowired
    public EmprestimoServiceImpl(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @Override
    public Emprestimo registrarEmprestimo(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = Emprestimo.builder()
                .idUsuario(emprestimoDTO.idUsuario())
                .idLivro(emprestimoDTO.idLivro())
                .dataEmprestimo(emprestimoDTO.dataEmprestimo())
                .dataDevolucaoPrevista(emprestimoDTO.dataDevolucaoPrevista())
                .build();
        return emprestimoRepository.save(emprestimo);
    }

    @Override
    public List<Emprestimo> listarEmprestimosPorUsuario(String idUsuario) {
        return emprestimoRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public List<Emprestimo> listarEmprestimosPorLivro(String idLivro) {
        return emprestimoRepository.findByIdLivro(idLivro);
    }
} 