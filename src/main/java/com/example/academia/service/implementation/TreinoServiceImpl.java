package com.example.academia.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.academia.service.TreinoService;
import com.example.academia.treino.Treino;
import com.example.academia.treino.TreinoRepository;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class TreinoServiceImpl implements TreinoService {

    private final TreinoRepository treinoRepository;

    @Autowired
    public TreinoServiceImpl(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    @Override
    public List<Treino> listarTreinos() {
        try {
            return treinoRepository.findAll();
        } catch (Exception e) {
            // Adicione um log ou imprima a exceção para depuração
            throw new RuntimeException("Erro ao listar treinos: " + e.getMessage());
        }
    }

 
    // @Override
    // public List<Treino> listarTreinosPorFaixa(String faixa) {
    //     try {
    //         return treinoRepository.findByFaixa(faixa);
    //     } catch (Exception e) {
    //         // Adicione um log ou imprima a exceção para depuração
    //         throw new RuntimeException("Erro ao listar treinos por faixa: " + e.getMessage());
    //     }
    // }

    @Override
public List<Treino> listarTreinosPorFaixa(String faixaNome) {
    try {
        return treinoRepository.findByFaixaNome(faixaNome);
    } catch (Exception e) {
        throw new RuntimeException("Erro ao listar treinos por faixa: " + e.getMessage());
    }
}

    @Override
    public Treino obterTreinoPorId(Long id) {
        return treinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }



    @Override
    public void addTreino(Treino treino, MultipartFile imagem) {
        validarTreino(treino);
        String caminhoImagem = salvarImagem(imagem);
        treino.setCaminhoImagem(caminhoImagem);
        treinoRepository.save(treino);
    }

    private void validarTreino(Treino treino) {
        if (treino.getNome() == null || treino.getDescricao() == null || treino.getFaixa() == null
                || treino.getHorarios() == null) {
            throw new IllegalArgumentException("Campos obrigatórios não preenchidos.");
        }
    }

    private String salvarImagem(MultipartFile imagem) {
        try {
            // Diretório onde as imagens serão salvas
            String diretorioImagens = "./uploads";

            // Obtém o nome original do arquivo
            String nomeArquivo = StringUtils.cleanPath(imagem.getOriginalFilename());

            // Cria o caminho completo para salvar o arquivo
            Path caminhoCompleto = Paths.get(diretorioImagens + "/" + nomeArquivo);

            // Salva o arquivo no diretório
            Files.copy(imagem.getInputStream(), caminhoCompleto);

            // Retorna o caminho relativo do arquivo salvo
            return "/uploads/" + nomeArquivo;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    @Override
    public Treino editarTreino(Long id, Treino treino, MultipartFile imagem) {
        Treino treinoExistente = treinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        // Atualiza os campos do treino
        treinoExistente.setNome(treino.getNome());
        treinoExistente.setDescricao(treino.getDescricao());
        treinoExistente.setFaixa(treino.getFaixa());
        treinoExistente.setHorarios(treino.getHorarios());

        // Atualiza a imagem, se fornecida
        if (imagem != null) {
            String caminhoImagem = salvarImagem(imagem);
            treinoExistente.setCaminhoImagem(caminhoImagem);
        }

        // Salva e retorna o treino atualizado
        return treinoRepository.save(treinoExistente);
    }

    @Override
    public void excluirTreino(Long id) {
        treinoRepository.deleteById(id);
    }
}
