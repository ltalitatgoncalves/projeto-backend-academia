// // // // package com.example.academia.controller;

// // // // import java.util.List;

// // // // import org.springframework.beans.factory.annotation.Autowired;
// // // // import org.springframework.web.bind.annotation.CrossOrigin;
// // // // import org.springframework.web.bind.annotation.GetMapping;
// // // // import org.springframework.web.bind.annotation.PostMapping;
// // // // import org.springframework.web.bind.annotation.RequestBody;
// // // // import org.springframework.web.bind.annotation.RequestMapping;
// // // // import org.springframework.web.bind.annotation.RestController;

// // // // import com.example.academia.usuario.Usuario;
// // // // import com.example.academia.usuario.UsuarioRepository;
// // // // import com.example.academia.usuario.UsuarioRequestDTO;
// // // // import com.example.academia.usuario.UsuarioResponseDTO;

// // // // @RestController
// // // // @RequestMapping("usuario")
// // // // public class UsuarioController {

// // // //     @Autowired
// // // //     private UsuarioRepository repository;

// // // //     @CrossOrigin(origins = "*", allowedHeaders = "*")
// // // //     @PostMapping
// // // //     public void creatUser(@RequestBody UsuarioRequestDTO data) {
// // // //         Usuario usuarioData = new Usuario(data);
// // // //         repository.save(usuarioData);
// // // //         return;
// // // //     }

// // // //     @CrossOrigin(origins = "*", allowedHeaders = "*")
// // // //     @GetMapping
// // // //     public List<UsuarioResponseDTO> getAllUser() {

// // // //         List<UsuarioResponseDTO> usuarioList = repository.findAll().stream().map(UsuarioResponseDTO::new).toList();
// // // //         return usuarioList;

// // // //     }

// // // //     public void Login(){

// // // //     }

// // // // }

// // package com.example.academia.controller;

// // import java.util.List;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.HttpStatus;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.CrossOrigin;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// // import com.example.academia.exception.BusinessRuleException;
// // import com.example.academia.exception.ErroAutentificacaoException;
// // import com.example.academia.service.UsuarioService;
// // import com.example.academia.usuario.Usuario;
// // import com.example.academia.usuario.UsuarioDTO;
// // import com.example.academia.usuario.UsuarioLoginDTO;
// // import com.example.academia.usuario.UsuarioRepository;
// // import com.example.academia.usuario.UsuarioResponseDTO;

// // import lombok.RequiredArgsConstructor;

// // @RestController
// // @RequestMapping("usuario")
// // @RequiredArgsConstructor
// // public class UsuarioController {
// //     private final UsuarioService service;

// //     @Autowired
// //     private UsuarioRepository repository;

// //     @CrossOrigin(origins = "*", allowedHeaders = "*")
// //     @GetMapping
// //     public ResponseEntity<List<UsuarioResponseDTO>> getAllUser() {
// //         List<UsuarioResponseDTO> usuarioList = repository.findAll().stream().map(UsuarioResponseDTO::new).toList();
// //         return ResponseEntity.ok(usuarioList);
// //     }

// //     // @CrossOrigin(origins = "*", allowedHeaders = "*")
// //     // @PostMapping("cadastrarUsuario")
// //     // public ResponseEntity<Object> save(@RequestBody UsuarioDTO dto) {
// //     // Usuario usuario = Usuario.builder()
// //     // .nome(dto.getNome())
// //     // .email(dto.getEmail())
// //     // .senha(dto.getSenha())
// //     // .faixa(dto.getFaixa()) // Adicione a faixa ao construtor
// //     // .build();

// //     // try {
// //     // var usuarioSalvo = service.cadastrar(usuario);
// //     // System.out.println("CADASTRO " + usuarioSalvo);
// //     // return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
// //     // } catch (BusinessRuleException ex) {
// //     // return ResponseEntity.badRequest().body(ex.getMessage());
// //     // }
// //     // }

// //     @PostMapping("cadastrarUsuario")
// //     public ResponseEntity<Object> save(@RequestBody UsuarioDTO dto) {
// //         Usuario usuario = Usuario.builder()
// //                 .nome(dto.getNome())
// //                 .email(dto.getEmail())
// //                 .senha(dto.getSenha())
// //                 .faixa(dto.getFaixa())
// //                 .admin(dto.getAdmin(false)) // Por padrão, o novo usuário não será um administrador
// //                 .build();

// //         try {
// //             var usuarioSalvo = service.cadastrar(usuario);
// //             System.out.println("CADASTRO " + usuarioSalvo);
// //             return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
// //         } catch (BusinessRuleException ex) {
// //             return ResponseEntity.badRequest().body(ex.getMessage());
// //         }
// //     }

// //     // @CrossOrigin(origins = "*", allowedHeaders = "*")
// //     // @PostMapping("/login")
// //     // public ResponseEntity<Object> autenticar(@RequestBody UsuarioLoginDTO dto) {
// //     //     try {
// //     //         Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
// //     //         System.out.println("Login sucesso." + usuarioAutenticado);
// //     //         return ResponseEntity.ok(usuarioAutenticado);
// //     //     } catch (ErroAutentificacaoException ex) {
// //     //         System.out.println("Login falhou.");
// //     //         return ResponseEntity.badRequest().body(ex.getMessage());
// //     //     }
// //     // }

// //     @CrossOrigin(origins = "*", allowedHeaders = "*")
// //     @PostMapping("/login")
// //     public ResponseEntity<Object> autenticar(@RequestBody UsuarioLoginDTO dto) {
// //         try {
// //             Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
// //             String token = gerarToken(usuarioAutenticado.getEmail());
// //             usuarioAutenticado.setToken(token);
// //             return ResponseEntity.ok(usuarioAutenticado);
// //         } catch (ErroAutentificacaoException ex) {
// //             return ResponseEntity.badRequest().body(ex.getMessage());
// //         }
// //     }

// //     private String gerarToken(String email) {
// //         return null;
// //     }

// // }

// package com.example.academia.controller;

// import java.util.List;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.academia.exception.BusinessRuleException;
// import com.example.academia.exception.ErroAutentificacaoException;
// import com.example.academia.faixa.Faixa;
// import com.example.academia.faixa.FaixaRepository;
// import com.example.academia.service.UsuarioService;
// import com.example.academia.usuario.Usuario;
// import com.example.academia.usuario.UsuarioDTO;
// import com.example.academia.usuario.UsuarioLoginDTO;
// import com.example.academia.usuario.UsuarioRepository;
// import com.example.academia.usuario.UsuarioResponseDTO;

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("usuario")
// @RequiredArgsConstructor
// public class UsuarioController {
//     private final UsuarioService service;

//     @Autowired
//     private UsuarioRepository repository;

//     @Autowired
//     private FaixaRepository faixaRepository;  // Certifique-se de que esta linha está presente


//     // @CrossOrigin(origins = "*", allowedHeaders = "*")
//     // @GetMapping
//     // public ResponseEntity<List<UsuarioResponseDTO>> getAllUser() {
//     // List<UsuarioResponseDTO> usuarioList =
//     // repository.findAll().stream().map(UsuarioResponseDTO::new).toList();
//     // return ResponseEntity.ok(usuarioList);
//     // }

//     @GetMapping
//     public ResponseEntity<List<UsuarioResponseDTO>> getAllUser() {
//         List<UsuarioResponseDTO> usuarioList = repository.findAll().stream().map(this::mapToUsuarioResponseDTO)
//                 .toList();
//         return ResponseEntity.ok(usuarioList);
//     }

// // No método mapToUsuarioResponseDTO
// private UsuarioResponseDTO mapToUsuarioResponseDTO(Usuario usuario) {
//     return new UsuarioResponseDTO(
//             usuario.getId(),
//             usuario.getNome(),
//             usuario.getEmail(),
//             usuario.getSenha(),
//             usuario.getFaixa() != null ? usuario.getFaixa().getNome() : null,
//             usuario.isAdmin());
// }

//     // @PostMapping("cadastrarUsuario")
//     // public ResponseEntity<Object> save(@RequestBody UsuarioDTO dto) {
//     // Usuario usuario = Usuario.builder()
//     // .nome(dto.getNome())
//     // .email(dto.getEmail())
//     // .senha(dto.getSenha())
//     // .faixa(dto.getFaixa())
//     // .admin(dto.getAdmin(false)) // Por padrão, o novo usuário não será um
//     // administrador
//     // .build();

//     // try {
//     // var usuarioSalvo = service.cadastrar(usuario);
//     // System.out.println("CADASTRO " + usuarioSalvo);
//     // return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
//     // } catch (BusinessRuleException ex) {
//     // return ResponseEntity.badRequest().body(ex.getMessage());
//     // }
//     // }

//     @PostMapping("cadastrarUsuario")
//     public ResponseEntity<Object> save(@RequestBody UsuarioDTO dto) {
//         Faixa faixa = faixaRepository.findById(dto.getFaixaId())
//                 .orElseThrow(() -> new BusinessRuleException("Faixa não encontrada."));
    
//         Usuario usuario = Usuario.builder()
//                 .nome(dto.getNome())
//                 .email(dto.getEmail())
//                 .senha(dto.getSenha())
//                 .faixa(faixa)
//                 .admin(dto.getAdmin(false))
//                 .build();
    
//         try {
//             var usuarioSalvo = service.cadastrar(usuario);
//             System.out.println("CADASTRO " + usuarioSalvo);
//             return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
//         } catch (BusinessRuleException ex) {
//             return ResponseEntity.badRequest().body(ex.getMessage());
//         }
//     }


//     @CrossOrigin(origins = "*", allowedHeaders = "*")
//     @PostMapping("/login")
//     public ResponseEntity<Object> autenticar(@RequestBody UsuarioLoginDTO dto) {
//         try {
//             Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
//             String token = TokenGenerator.generateToken();
//             usuarioAutenticado.setToken(token);
//             return ResponseEntity.ok(usuarioAutenticado);
//         } catch (ErroAutentificacaoException ex) {
//             return ResponseEntity.badRequest().body(ex.getMessage());
//         }
//     }

//     private static class TokenGenerator {
//         public static String generateToken() {
//             UUID uuid = UUID.randomUUID();
//             return uuid.toString().replace("-", "");
//         }
//     }
// }



package com.example.academia.controller;

import java.util.List;
import java.util.UUID;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.exception.BusinessRuleException;
import com.example.academia.exception.ErroAutentificacaoException;
import com.example.academia.faixa.FaixaRepository;
import com.example.academia.service.UsuarioService;
import com.example.academia.usuario.Usuario;
import com.example.academia.usuario.UsuarioDTO;
import com.example.academia.usuario.UsuarioLoginDTO;
import com.example.academia.usuario.UsuarioRepository;
import com.example.academia.usuario.UsuarioResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService service;
    private final UsuarioRepository repository;
    private final FaixaRepository faixaRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getAllUser() {
        List<UsuarioResponseDTO> usuarioList = repository.findAll().stream().map(this::mapToUsuarioResponseDTO)
                .toList();
        return ResponseEntity.ok(usuarioList);
    }

    @PostMapping("cadastrarUsuario")
    public ResponseEntity<Object> save(@RequestBody UsuarioDTO dto) {
        if (dto.getFaixaId() == null) {
            return ResponseEntity.badRequest().body("ID da faixa não pode ser nulo.");
        }

        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .faixa(faixaRepository.findById(dto.getFaixaId())
                        .orElseThrow(() -> new BusinessRuleException("Faixa não encontrada.")))
                .admin(dto.getAdmin(false))
                .build();

        try {
            var usuarioSalvo = service.cadastrar(usuario);
            System.out.println("CADASTRO " + usuarioSalvo);
            return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
        } catch (BusinessRuleException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity<Object> autenticar(@RequestBody UsuarioLoginDTO dto) {
        try {
            Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
            String token = TokenGenerator.generateToken();
            usuarioAutenticado.setToken(token);
            return ResponseEntity.ok(usuarioAutenticado);
        } catch (ErroAutentificacaoException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    private UsuarioResponseDTO mapToUsuarioResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getFaixa() != null ? usuario.getFaixa().getNome() : null,
                usuario.isAdmin());
    }

    private static class TokenGenerator {
        public static String generateToken() {
            UUID uuid = UUID.randomUUID();
            return uuid.toString().replace("-", "");
        }
    }
}
