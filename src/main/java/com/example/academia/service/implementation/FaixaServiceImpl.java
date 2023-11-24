// package com.example.academia.service.implementation;

// import com.example.academia.service.FaixaService;

// public class FaixaServiceImpl extends FaixaService{
    
// }


package com.example.academia.service.implementation;

import com.example.academia.faixa.Faixa;
import com.example.academia.faixa.FaixaRepository;
import com.example.academia.service.FaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaixaServiceImpl implements FaixaService {

    private final FaixaRepository faixaRepository;

    @Autowired
    public FaixaServiceImpl(FaixaRepository faixaRepository) {
        this.faixaRepository = faixaRepository;
    }

    @Override
    public List<Faixa> listarFaixas() {
        return faixaRepository.findAll();
    }

    @Override
    public Faixa obterFaixaPorId(Long id) {
        return faixaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faixa não encontrada"));
    }
}
