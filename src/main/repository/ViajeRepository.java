package es.upm.dit.isst.tfgapi.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ViajeRepository extends CrudRepository<Viaje, Int> {
    List<viaje> findByNombre(String nombre);
}
