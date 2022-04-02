package es.upm.dit.apsv.ordermanager.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import es.upm.dit.apsv.ordermanager.model.Viaje;

public interface ViajeRepository extends CrudRepository<Viaje, Long> {
    List<Viaje> findByNombre(String nombre);
}
