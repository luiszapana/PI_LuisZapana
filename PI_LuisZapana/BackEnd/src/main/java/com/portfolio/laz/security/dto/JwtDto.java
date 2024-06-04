package com.portfolio.laz.security.dto;

import java.util.Collection;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
@RequiredArgsConstructor //Se utiliza para no poner el campo bearer en el constructor
public class JwtDto {
    @NonNull
    private String token;
    private String bearer = "Bearer";
    @NonNull
    private String nombreUsuario;
    @NonNull
    private Collection<? extends GrantedAuthority> authorities;
}
