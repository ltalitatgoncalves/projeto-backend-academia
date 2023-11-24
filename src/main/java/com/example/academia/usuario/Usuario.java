// package com.example.academia.usuario;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;

// import lombok.NoArgsConstructor;

// import lombok.Builder;
// import lombok.Data;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Table(name = "usuario")
// public class Usuario {

//     @Id
//     @Column(name = "id")
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "nome")
//     private String nome;

//     @Column(name = "email")
//     private String email;

//     @Column(name = "faixa")
//     private String faixa;

//     @Column(name = "senha")
//     @JsonIgnore
//     private String senha;
// }

package com.example.academia.usuario;

import com.example.academia.faixa.Faixa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    // @Column(name = "faixa")
    // private String faixa;

    @Column(name = "senha")
    @JsonIgnore
    private String senha;

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "token")
    private String token;

     @ManyToOne
    @JoinColumn(name = "faixa_id") // Coluna que representa a chave estrangeira
    private Faixa faixa;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
