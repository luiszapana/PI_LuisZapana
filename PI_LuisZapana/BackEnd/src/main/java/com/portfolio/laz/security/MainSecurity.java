package com.portfolio.laz.security;

import com.portfolio.laz.security.jwt.JwtEntryPoint;
import com.portfolio.laz.security.jwt.JwtTokenFilter;
import com.portfolio.laz.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; //deprecated
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; 

@Configuration
@EnableWebSecurity
@EnableMethodSecurity (prePostEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true) // Esta anotación está obsoleta y se debe usar @EnableMethodSecurity en su lugar
public class MainSecurity{
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
