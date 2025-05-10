package com.biblioteca.biblioteca.interfacce;

import com.biblioteca.biblioteca.dto.EmprestimoDTO;
import com.biblioteca.biblioteca.model.Emprestimo;
import java.util.List;

public interface IEmprestimoService {
    Emprestimo registrarEmprestimo(EmprestimoDTO emprestimoDTO);
    List<Emprestimo> listarEmprestimosPorUsuario(String idUsuario);
    List<Emprestimo> listarEmprestimosPorLivro(String idLivro);
} 