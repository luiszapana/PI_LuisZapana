package com.portfolio.laz.security.service;

import com.portfolio.laz.security.entity.Usuario;
import com.portfolio.laz.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service//lógica de negocio y las operaciones de servicio que no están directamente relacionadas con la presentación o la persistencia
public class UserDetailsServiceImpl implements UserDetailsService{
//UDS Se utiliza para recuperar los detalles del usuario durante el proceso de autenticación.
    @Autowired
    UsuarioService usuarioService;
    
    
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
       Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
       return UsuarioPrincipal.build(usuario);
    }
    
}
