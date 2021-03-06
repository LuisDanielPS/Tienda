/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.lPaisService;
import com.tienda.service.lPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {
    
    @Autowired
    private lPersonaService PersonaService;
    private lPaisService PaisService;
    
    @GetMapping("/persona")
    public String index (Model model){
        List<Persona> listaPersona = PersonaService.getAllPersona();
        model.addAttribute("titulo","Tabla Personas");
        model.addAttribute("personas",listaPersona);
        return "personas";
    }
    
        @GetMapping("/personaN")
        public String crearPersona(Model model) {
        List<Pais> listaPaises = PaisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPaises);
        return "crear";
    }
    
    @PostMapping("/save")
        public String guardarPersona(@ModelAttribute Persona persona) {
        PersonaService.savePersona(persona);
        return "redirect:/persona";
    }
        
    @GetMapping("/editPersona/{id}")
        public String editarPersona(@PathVariable("id") Long idPersona,Model model) {
        Persona persona = PersonaService.getPersonaById(idPersona);        
        List<Pais> listaPaises = PaisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPaises);
        return "crear";
    }
    @GetMapping("/delete/{id}")
        public String eliminarPersona(@PathVariable("id") Long idPersona) {
        PersonaService.delete(idPersona);
        return "redirect:/persona";
    }
    
}
