// // package com.example.academia.JWT;

// // import java.io.IOException;

// // import org.springframework.web.filter.OncePerRequestFilter;

// // import jakarta.servlet.FilterChain;
// // import jakarta.servlet.ServletException;
// // import jakarta.servlet.http.HttpServletRequest;
// // import jakarta.servlet.http.HttpServletResponse;

// // public class JwtAuthenticationFilter extends OncePerRequestFilter  {

// //     @Override
// //     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
// //             throws ServletException, IOException {
      
// //         throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
// //     }
    
// // }



// package com.example.academia.JWT;

// import java.io.IOException;

// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class JwtAuthenticationFilter extends OncePerRequestFilter  {

//     private static final String SecurityContextHolder = null;
//     private final JwtUtil jwtUtil;

//     public JwtAuthenticationFilter(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//     String header = request.getHeader("Authorization");
//     if (header != null && header.startsWith("Bearer ")) {
//         String token = header.substring(7);
//         if (jwtUtil.validarToken(token)) {
//             String username = jwtUtil.extrairUsername(token);
//             UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, null);
//             SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//         }
//     }

//     filterChain.doFilter(request, response);
// }
    

