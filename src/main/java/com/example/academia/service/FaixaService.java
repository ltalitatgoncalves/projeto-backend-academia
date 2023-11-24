package com.example.academia.service;


import com.example.academia.faixa.Faixa;

import java.util.List;

public interface FaixaService {
    List<Faixa> listarFaixas();

    Faixa obterFaixaPorId(Long id);
}
