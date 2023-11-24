// package com.example.academia.JWT;

// import javax.swing.text.PasswordView;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// import com.example.academia.service.UsuarioService;

// @Configuration
// @EnableWebMvc
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private UsuarioService usuarioDetailsService;

//     @Bean
//     public PasswordView passwordEncoder() {
//         return new PasswordView();
//     }

//     @Bean
//     public JwtAuthenticationFilter jwtAuthenticationFilter() {
//         return new JwtAuthenticationFilter(null);
//     }

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(usuarioDetailsService).passwordEncoder(passwordEncoder());
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeRequests()
//                 .antMatchers("/usuario/login").permitAll()
//                 .anyRequest().authenticated()
//             .and()
//                 .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationToken.class);
//     }
// }
