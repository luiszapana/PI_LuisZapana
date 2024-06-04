package com.portfolio.laz.security.service;

import com.portfolio.laz.security.entity.Rol;
import com.portfolio.laz.security.enums.RolNombre;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.laz.security.repository.IRolRepository;

@Service
@Transactional //Hace un rollback si una operación falla.
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}
