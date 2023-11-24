package com.example.academia.faixa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FaixaRepository extends JpaRepository<Faixa, Long> {

    Optional<Faixa> findByNome(String faixa);
}