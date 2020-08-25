package ar.com.ada.api.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.repositories.MuestraRepository;

@Service
public class MuestraService {
    
    @Autowired
    MuestraRepository muestraRepository;
}