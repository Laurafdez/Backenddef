package es.upm.dit.apsv.ordermanager.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import es.upm.dit.apsv.ordermanager.model.Vehiculo;
import es.upm.dit.apsv.ordermanager.repository.VehiculoRepository;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {
    List<Vehiculo> findAll();

}
