package com.portfolio.laz.security.repository;

import com.portfolio.laz.security.entity.Rol;
import com.portfolio.laz.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRollRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRollNombre(RolNombre rolNombre);
    
}
