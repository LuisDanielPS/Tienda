/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements lPersonaService{

    @Autowired
    private PersonaRepository PersonaRepository;

    @Override
    public List<Persona>getAllPersona(){
        return (List<Persona>)PersonaRepository.findAll();
    }
    
    @Override
    public Persona getPersonaById(long id){
        return PersonaRepository.findById(id).orElse(null);
    }
    
    @Override
    public void savePersona(Persona persona){
        PersonaRepository.save(persona);
    }
    
    @Override
    public void delete(long id){
        PersonaRepository.deleteById(id);
    }
            
    


    
}
