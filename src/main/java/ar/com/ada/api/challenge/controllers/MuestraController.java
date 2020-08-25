package ar.com.ada.api.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.services.MuestraService;

@RestController
public class MuestraController {


    @Autowired
    MuestraService muestraService;


    
}