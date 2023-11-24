package com.example.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.faixa.Faixa;
import com.example.academia.faixa.FaixaRepository;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/faixas")
public class FaixaController {
    @Autowired
    private FaixaRepository faixaRepository;

    

    @GetMapping("/listarFaixas")
    public List<Faixa> listarFaixas() {
        return faixaRepository.findAll();
    }
}
