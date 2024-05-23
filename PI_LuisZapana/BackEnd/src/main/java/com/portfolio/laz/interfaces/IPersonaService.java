package com.portfolio.laz.interfaces;

import com.portfolio.laz.entity.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas();
    
    public void savePersona (Persona persona);
    
    public void deletePersona (Long id);
    
    public Persona findPersona(Long id);
}
