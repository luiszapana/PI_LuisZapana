package com.portfolio.laz.security.service;

import com.portfolio.laz.security.entity.Rol;
import com.portfolio.laz.security.enums.RolNombre;
import com.portfolio.laz.security.repository.IRollRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRollRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return iRolRepository.findByRollNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}
