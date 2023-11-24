package com.example.academia.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String nome;

    private String email;

    private String faixa;

    private String senha;

    private Long faixaId; // Certifique-se de que este campo está presente

    public boolean getAdmin(boolean b) {
        return false;
    }

}
