package com.Grupo10OO22021.services.impl;

import com.Grupo10OO22021.converters.PersonaConverter;
import com.Grupo10OO22021.models.PersonaModel;
import com.Grupo10OO22021.repository.IPersonaRepository;
import com.Grupo10OO22021.services.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

@Service("personaService")
public class PersonaService implements IPersonaService{
    
    @Autowired
    @Qualifier("personaConverter")
    private PersonaConverter personaConverter;

    @Autowired
    @Qualifier("personaRepository")
    private IPersonaRepository personaRepository;

    public PersonaModel insertOrUpdate(PersonaModel persona){
        return personaConverter.entityToModel(personaRepository.save(personaConverter.modelToEntity(persona)));
    }
}
