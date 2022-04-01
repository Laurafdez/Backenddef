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

public class VehiculoController {

    private final VehiculoRepository vehiculoRepository;

    public static final Logger log = LoggerFactory.getLogger(VehiculoController.class);

    public VehiculoController(VehiculoRepository t) {

        this.vehiculoRepository = t;

    }

    @GetMapping("/vehiculos")

    List<Vehiculo> readAll() {

      return (List<Vehiculo>) vehiculoRepository.findAll();

    }

 

    @PostMapping("/vehiculos")

    ResponseEntity<Vehiculo> create(@RequestBody Vehiculo newVehiculo) throws URISyntaxException {

      Vehiculo result = vehiculoRepository.save(newVehiculo);

      return ResponseEntity.created(new URI("/vehiculos/" + result.getEmail())).body(result);

    }

 

    @GetMapping("/vehiculos/{id}")

    ResponseEntity<Vehiculo> read(@PathVariable String id) {

      return vehiculoRepository.findById(id).map(vehiculo ->

         ResponseEntity.ok().body(vehiculo)

      ).orElse(new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("/vehiculos/{id}")

    ResponseEntity<Vehiculo> update(@RequestBody Vehiculo newVehiculo, @PathVariable String id) {

      return vehiculoRepository.findById(id).map(vehiculo -> {

        vehiculo.setNombre(newVehiculo.getNombre());

        vehiculo.setTitulo(newVehiculo.getTitulo());

        vehiculo.setTutor(newVehiculo.getTutor());

        vehiculo.setStatus(newVehiculo.getStatus());

        vehiculo.setNota(newVehiculo.getNota());

        vehiculo.setMemoria(newVehiculo.getMemoria());

        vehiculoRepository.save(vehiculo);

        return ResponseEntity.ok().body(vehiculo);

      }).orElse(new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("vehiculos/{id}")

    ResponseEntity<Vehiculo> delete(@PathVariable String id) {

      vehiculoRepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }

    @GetMapping("/vehiculos/profesor/{id}")

    List<Vehiculo> readTutor(@PathVariable String id) {

      return (List<Vehiculo>) vehiculoRepository.findByTutor(id);

    }

    @PostMapping("/vehiculos/{id}/incrementa")

    ResponseEntity<Vehiculo> incrementa(@PathVariable String id) {

      return vehiculoRepository.findById(id).map(vehiculo -> {

        vehiculo.setStatus(vehiculo.getStatus() + 1);

        vehiculoRepository.save(vehiculo);

        return ResponseEntity.ok().body(vehiculo);

      }).orElse(new ResponseEntity<Vehiculo>(HttpStatus.NOT_FOUND));  

    }

}
