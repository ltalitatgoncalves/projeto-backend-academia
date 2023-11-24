// package com.example.academia.usuario;


// public record UsuarioResponseDTO(Long id, String nome, String email, String senha, String faixa, Boolean admin) {
    
//     public UsuarioResponseDTO(Usuario usuario){
//         this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getFaixa(), usuario.isAdmin());
//     }
// }


package com.example.academia.usuario;


public record UsuarioResponseDTO(Long id, String nome, String email, String senha, String faixa, Boolean admin) {
    
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), 
             usuario.getFaixa() != null ? usuario.getFaixa().getNome() : null, usuario.isAdmin());
    }
}

