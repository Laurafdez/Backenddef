package es.upm.dit.isst.tfgapi.controller;

import es.upm.dit.isst.tfgapi.repository.userRepository;

import org.apache.catalina.User;
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

public class UserController {

    private final UserRepository userRepository;

    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository t) {

        this.userRepository = t;

    }

    @GetMapping("/users")

    List<User> readAll() {

      return (List<User>) userRepository.findAll();

    }

 

    @PostMapping("/users")

    ResponseEntity<User> create(@RequestBody User newUser) throws URISyntaxException {

      User result = userRepository.save(newUser);

      return ResponseEntity.created(new URI("/user/" + result.getEmail())).body(result);

    }

 

    @GetMapping("/users/{id}")

    ResponseEntity<User> read(@PathVariable String id) {

      return userRepository.findById(id).map(user ->

         ResponseEntity.ok().body(user)

      ).orElse(new ResponseEntity<User>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("/users/{id}")

    ResponseEntity<User> update(@RequestBody User newUser, @PathVariable String id) {

      return userRepository.findById(id).map(user -> {

        user.setNombre(newUser.getNombre());

        user.setTitulo(newUser.getApellido());

        user.setTutor(newUser.getVeh());


        userRepository.save(user);

        return ResponseEntity.ok().body(user);

      }).orElse(new ResponseEntity<TFG>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("users/{id}")

    ResponseEntity<User> delete(@PathVariable String id) {

      userRepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }

    @GetMapping("/users/nombre/{id}")

    List<User> readNombreList(@PathVariable String id) {

      return (List<User>) userRepository.findByNombre(id);

    }

}
