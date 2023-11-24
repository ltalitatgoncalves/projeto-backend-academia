package com.example.academia.faixa;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "faixa")
@Data
public class Faixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

}
