package es.upm.dit.apsv.ordermanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import es.upm.dit.apsv.ordermanager.model.Viaje;
import es.upm.dit.apsv.ordermanager.repository.ViajeRepository;


@RestController

public class ViajeController {

    private final ViajeRepository viajeRepository;

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

      return ResponseEntity.created(new URI("/viajes/" + result.getIdviaje())).body(result);

    }

 

    @GetMapping("/viajes/{id}")

    ResponseEntity<Viaje> read(@PathVariable String id) {

      return viajeRepository.findById(Long.parseLong(id)).map(viaje ->

         ResponseEntity.ok().body(viaje)

      ).orElse(new ResponseEntity<Viaje>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("/viajes/{id}")

    ResponseEntity<Viaje> update(@RequestBody Viaje newViaje, @PathVariable String id) {

      return viajeRepository.findById(Long.parseLong(id)).map(viaje -> {

        viaje.setFecha(newViaje.getFecha());

        viaje.setTiempo(newViaje.getTiempo());

        viaje.setId(newViaje.getId());

        viaje.setStatus(newViaje.getStatus());

        viaje.setUbini(newViaje.getUbini());

        viaje.setUbifin(newViaje.getUbifin());

        viajeRepository.save(viaje);

        return ResponseEntity.ok().body(viaje);

      }).orElse(new ResponseEntity<Viaje>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("viajes/{id}")

    ResponseEntity<Viaje> delete(@PathVariable String id) {

      Long ideLong=Long.parseLong(id);

      viajeRepository.deleteById(ideLong);

      return ResponseEntity.ok().body(null);

    }

    @GetMapping("/viajes/{id}")

    List<Viaje> readViaje (@PathVariable String id) {

      return (List<Viaje>) viajeRepository.findByNombre(id);

    }

    @PostMapping("/viajes/{id}/incrementa")

    ResponseEntity<Viaje> incrementa(@PathVariable String id) {

      return viajeRepository.findById(Long.parseLong(id)).map(viaje -> {

        viaje.setStatus(viaje.getStatus() + 1);

        viajeRepository.save(viaje);

        return ResponseEntity.ok().body(viaje);

      }).orElse(new ResponseEntity<Viaje>(HttpStatus.NOT_FOUND));  

    }

}
