// package com.example.academia.usuario;

// import org.springframework.data.jpa.repository.JpaRepository;

// public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//      // Adicione o método personalizado
//      Usuario findByCredenciaisEmailUsuario(String email);
//      Usuario findByEmail(String email);

// }

package com.example.academia.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

}
