package com.example.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.academia.service.TreinoService;
import com.example.academia.treino.Treino;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    @Autowired
    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @PostMapping("/cadastrarTreino")
    public ResponseEntity<String> addTreino(Treino treino, @RequestPart("imagem") MultipartFile imagem) {
        try {
            treinoService.addTreino(treino, imagem);
            return new ResponseEntity<>("Treino cadastrado com sucesso.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar treino: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarTreinos")
    public ResponseEntity<List<Treino>> listarTreinos() {
        List<Treino> treinos = treinoService.listarTreinos();
        return new ResponseEntity<>(treinos, HttpStatus.OK);
    }

    
    @GetMapping("/listarTreinos/{id}")
    public ResponseEntity<Treino> obterTreinoPorId(@PathVariable Long id) {
        try {
            Treino treino = treinoService.obterTreinoPorId(id);
            return ResponseEntity.ok(treino);
        } catch (Exception e) {
            return new ResponseEntity<Treino>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarTreinosPorFaixa/{faixa}")
    public ResponseEntity<List<Treino>> listarTreinosPorFaixa(@PathVariable String faixa) {
        System.out.println("Faixa do usuário: " + faixa);
        List<Treino> treinos = treinoService.listarTreinosPorFaixa(faixa);
        System.out.println("Treinos encontrados: " + treinos.size());
        return new ResponseEntity<>(treinos, HttpStatus.OK);
    }

    @PutMapping("/editarTreino/{id}")
    public ResponseEntity<String> editarTreino(Treino treino, @RequestPart("imagem") MultipartFile imagem) {
        try {
            treinoService.addTreino(treino, imagem);
            return new ResponseEntity<>("Treino cadastrado com sucesso.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar treino: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/excluirTreino/{id}")
    public ResponseEntity<String> excluirTreino(@PathVariable Long id) {
        try {
            treinoService.excluirTreino(id);
            return new ResponseEntity<>("Treino excluído com sucesso.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao excluir treino: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
