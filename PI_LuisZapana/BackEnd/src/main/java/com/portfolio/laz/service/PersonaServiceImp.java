package com.portfolio.laz.service;

import com.portfolio.laz.entity.Persona;
import com.portfolio.laz.interfaces.IPersonaService;
import com.portfolio.laz.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements IPersonaService{
    @Autowired
    private IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> personas = iPersonaRepository.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;
    }    
}
