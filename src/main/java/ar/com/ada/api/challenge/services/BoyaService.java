package ar.com.ada.api.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.entities.Boya;
import ar.com.ada.api.challenge.repositories.BoyaRepository;

@Service
public class BoyaService {

    @Autowired
    BoyaRepository boyaRepository;


    public void crearBoya(Boya boya) {
        boyaRepository.save(boya);
    }

    public List<Boya> obtenerBoyas() {
        return boyaRepository.findAll();
    }

    public Boya obtenerPorId(Integer boyaId) {
        Optional<Boya> b = boyaRepository.findById(boyaId);
        if (b.isPresent())
            return b.get();
        return null;

    }


}
