package ar.com.ada.api.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.entities.Boya;
import ar.com.ada.api.challenge.models.request.BoyaRequest;
import ar.com.ada.api.challenge.models.request.ColorRequest;
import ar.com.ada.api.challenge.models.response.ColorResponse;
import ar.com.ada.api.challenge.models.response.GenericResponse;
import ar.com.ada.api.challenge.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService boyaService;

    @PostMapping("/api/boyas")
    public ResponseEntity<GenericResponse> crearBoyas(@RequestBody BoyaRequest bR) {
        Boya boya = new Boya();
        boya.setLatInst(bR.latInst);
        boya.setLongInst(bR.longInst);
        boyaService.crearBoya(boya);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.message = "Boya creada con exito";

        return ResponseEntity.ok(gR);
    }

    @GetMapping("/api/boyas")
    public ResponseEntity<List<Boya>> listarBoyas() {
        return ResponseEntity.ok(boyaService.obtenerBoyas());
    }

    @GetMapping("api/boyas/{id}")
    public ResponseEntity<Boya> obtenerInfoBoya(@PathVariable Integer id) {
        return ResponseEntity.ok(boyaService.obtenerPorId(id));
    }
    @PutMapping("api/boyas/{id}")
    public ResponseEntity<GenericResponse> actualizarColor(@PathVariable int id,
            @RequestBody ColorRequest cR) {
        Boya boya = boyaService.obtenerPorId(id);
        if (boya == null) {
            return ResponseEntity.notFound().build();
        }
        boya.setColor(cR.color);
        boyaService.crearBoya(boya);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.message = "Color actualizado con exito";
        return ResponseEntity.ok(gR);
    }


}