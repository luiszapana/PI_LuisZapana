package com.portfolio.laz.security;

import com.portfolio.laz.security.jwt.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration //En los métodos marcados como bean se omite el modificador public
@EnableWebSecurity //Las urls pasan por el método securityFilterChain
@RequiredArgsConstructor
public class MainSecurity {

    private final JwtTokenFilter jwtTokenFilter;
    private final AuthenticationProvider authProvider;

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
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
