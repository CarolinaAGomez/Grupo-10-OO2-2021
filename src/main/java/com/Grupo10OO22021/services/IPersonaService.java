package com.Grupo10OO22021.services;

import java.util.List;

import com.Grupo10OO22021.entities.Persona;
import com.Grupo10OO22021.models.PersonaModel;

public interface IPersonaService {
    
    public PersonaModel insertOrUpdate(PersonaModel persona);
    
    public List<Persona> GetAll();
    
    public PersonaModel traerDniPersona(long dni);
    
    public PersonaModel traerIdPersona(int idPersona);
}
