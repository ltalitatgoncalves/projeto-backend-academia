package com.example.academia.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.academia.treino.Treino;

public interface TreinoService {
    void addTreino(Treino treino, MultipartFile imagem);

    List<Treino> listarTreinos();

    Treino obterTreinoPorId(Long id);

    Treino editarTreino(Long id, Treino treino, MultipartFile imagem);

    void excluirTreino(Long id);

    List<Treino> listarTreinosPorFaixa(String faixa);
    
}
