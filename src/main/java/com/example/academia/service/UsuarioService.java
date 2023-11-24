package com.example.academia.service;

import com.example.academia.usuario.Usuario;

public interface UsuarioService {
    Usuario autenticar(String email, String senha);
    Usuario cadastrar(Usuario usuario);
    void validarEmail(String email);
	Usuario obterPorId(Long id);
    String obterNomeDaFaixa(String faixa);
}
