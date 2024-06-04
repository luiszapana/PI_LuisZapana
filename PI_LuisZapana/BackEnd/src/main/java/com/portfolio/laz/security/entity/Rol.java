package com.portfolio.laz.security.entity;

import com.portfolio.laz.security.enums.RolNombre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Mati definió este campo como int
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
