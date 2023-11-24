// package com.example.academia.JWT;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtUtil {

//     public String gerarToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setExpiration(new Date(System.currentTimeMillis() + JwtConfig.EXPIRATION_TIME))
//                 .signWith(SignatureAlgorithm.HS512, JwtConfig.SECRET)
//                 .compact();
//     }

//     public String extrairUsuario(String token) {
//         return Jwts.parser().setSigningKey(JwtConfig.SECRET).parseClaimsJws(token).getBody().getSubject();
//     }

//     public boolean validarToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(JwtConfig.SECRET).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }
// }
