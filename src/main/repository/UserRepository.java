package es.upm.dit.isst.tfgapi.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByNombre(String nombre);
}
