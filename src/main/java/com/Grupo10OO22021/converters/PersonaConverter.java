package com.Grupo10OO22021.converters;

import org.springframework.stereotype.Component;

import com.Grupo10OO22021.entities.Persona;
import com.Grupo10OO22021.models.PersonaModel;
import com.Grupo10OO22021.models.UsuarioModel;

@Component("personaConverter")
public class PersonaConverter {
	
	
	
	  public PersonaModel entityToModel(Persona persona) {
			PersonaModel personaModel = null;
			if(persona != null){
			
				personaModel = new PersonaModel
						(persona.getIdPersona(),
						persona.getNombre(),
						persona.getApellido(),
						persona.getDni());
				
		}
			return personaModel;
		}
	
	
	  
	  public Persona modelToEntity(PersonaModel personaModel) {
		  Persona persona = null;
			if(personaModel != null){
			
				persona= new Persona
					(personaModel.getIdPersona(),
							personaModel.getNombre(), 
							personaModel.getApellido(),
							personaModel.getDni());
				
				
		}
			return persona;
		/*
	
	public Persona modelToEntity(PersonaModel personaModel) {
		
		return new Persona
				(personaModel.getIdPersona(),
						personaModel.getNombre(), 
						personaModel.getApellido(),
						personaModel.getDni());
	}
	

*/

}}