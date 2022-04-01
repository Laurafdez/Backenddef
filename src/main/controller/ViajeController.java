package es.upm.dit.isst.tfgapi.controller;

import es.upm.dit.isst.tfgapi.repository.TFGRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import es.upm.dit.isst.tfgapi.model.TFG;

@RestController

public class ViajeController {

    private final VajeRepository viajeRepository;

    public static final Logger log = LoggerFactory.getLogger(ViajeController.class);

    public ViajeController(ViajeRepository t) {

        this.viajeRepository = t;

    }

    @GetMapping("/viajes")

    List<Viaje> readAll() {

      return (List<Viaje>) viajeRepository.findAll();

    }

 

    @PostMapping("/viajess")

    ResponseEntity<Viaje> create(@RequestBody Viaje newViaje) throws URISyntaxException {

      Viaje result = viajeRepository.save(newViaje);

      return ResponseEntity.created(new URI("/viajes/" + result.getEmail())).body(result);

    }

 

    @GetMapping("/viajes/{id}")

    ResponseEntity<Viaje> read(@PathVariable String id) {

      return viajeRepository.findById(id).map(viaje ->

         ResponseEntity.ok().body(viaje)

      ).orElse(new ResponseEntity<Viaje>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("/viajes/{id}")

    ResponseEntity<Viaje> update(@RequestBody Viaje newViaje, @PathVariable String id) {

      return viajeRepository.findById(id).map(viaje -> {

        viaje.setNombre(newViaje.getNombre());

        viaje.setTitulo(newViaje.getTitulo());

        viaje.setTutor(newViaje.getTutor());

        viaje.setStatus(newViaje.getStatus());

        viaje.setNota(newViaje.getNota());

        viaje.setMemoria(newViaje.getMemoria());

        viajeRepository.save(viaje);

        return ResponseEntity.ok().body(viaje);

      }).orElse(new ResponseEntity<Viaje>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("viajes/{id}")

    ResponseEntity<Viaje> delete(@PathVariable String id) {

      viajeRepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }

    @GetMapping("/viajes/profesor/{id}")

    List<Viaje> readTutor(@PathVariable String id) {

      return (List<Viaje>) viajeRepository.findByTutor(id);

    }

    @PostMapping("/viajes/{id}/incrementa")

    ResponseEntity<Viaje> incrementa(@PathVariable String id) {

      return viajeRepository.findById(id).map(viaje -> {

        viaje.setStatus(viaje.getStatus() + 1);

        viajeRepository.save(viaje);

        return ResponseEntity.ok().body(viaje);

      }).orElse(new ResponseEntity<Viaje>(HttpStatus.NOT_FOUND));  

    }

}
