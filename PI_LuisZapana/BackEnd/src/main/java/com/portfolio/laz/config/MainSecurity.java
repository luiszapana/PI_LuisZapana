package com.portfolio.laz.config;

import com.portfolio.laz.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //En los métodos marcados como bean se omite el modificador public
@EnableWebSecurity //Las urls pasan por el método securityFilterChain
@RequiredArgsConstructor
public class MainSecurity { //Ivana llamó a esta clase SecurityConfig

    private final AuthenticationProvider authProvider;
     private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {//cadena de filtros, SecurityFilterChain se utiliza en lugar de WebSecurityConfigurerAdapter
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest -> authRequest
                    .requestMatchers("/auth/**").permitAll() //permite todas las urls que deriven de auth
                    .anyRequest().authenticated() //cualquier otra url requiere autenticación
                )
                .sessionManagement(sessionManager
                        -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
