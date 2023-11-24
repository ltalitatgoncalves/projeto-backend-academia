package com.example.academia.treino;

import lombok.Data;

import com.example.academia.faixa.Faixa;

import jakarta.persistence.*;

@Entity
@Table(name = "treino")
@Data
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    // @Column(name = "faixa")
    // private String faixa;

    @Column(name = "horarios")
    private String horarios;

    @Column(name = "caminho_imagem")
    private String caminhoImagem;

    @ManyToOne
    @JoinColumn(name = "faixa")
    private Faixa faixa;

}
