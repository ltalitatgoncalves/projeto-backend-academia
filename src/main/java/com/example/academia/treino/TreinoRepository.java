package com.example.academia.treino;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
  //  List<Treino> findByFaixa(String faixa);

    List<Treino> findByFaixaNome(String faixaNome);
    
}
