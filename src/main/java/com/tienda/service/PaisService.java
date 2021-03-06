/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Pais;
import com.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService implements lPaisService {
    
    @Autowired
    private PaisRepository PaisRepository;
    
    @Override
    public List<Pais> listCountry(){
        return (List<Pais>)PaisRepository.findAll();
    }
    
}
