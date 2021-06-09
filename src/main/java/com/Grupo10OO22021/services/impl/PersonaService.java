package com.Grupo10OO22021.services.impl;

import com.Grupo10OO22021.converters.PersonaConverter;
import com.Grupo10OO22021.entities.Persona;
import com.Grupo10OO22021.models.PersonaModel;
import com.Grupo10OO22021.models.UsuarioModel;
import com.Grupo10OO22021.repository.IPersonaRepository;
import com.Grupo10OO22021.services.IPersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Override
	public List<Persona> GetAll() {
		
		return personaRepository.findAll();
	}

	@Override
	public PersonaModel traerDniPersona(long dni) {
		
	PersonaModel persona = personaConverter.entityToModel(personaRepository.findByDni(dni));
		return persona;
	}

	@Override
	public PersonaModel traerIdPersona(int idPersona) {
		PersonaModel persona = personaConverter.entityToModel(personaRepository.findByIdPersona(idPersona));
		return persona;
	}
}
