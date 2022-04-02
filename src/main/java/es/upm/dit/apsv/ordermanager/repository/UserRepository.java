package es.upm.dit.apsv.ordermanager.repository;

import es.upm.dit.apsv.ordermanager.repository.UserRepository;
import es.upm.dit.apsv.ordermanager.model.User;


import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
import java.util.List;


public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByNombre(String nombre);
    List<User> readAll();
    List<User> findAll();

}
