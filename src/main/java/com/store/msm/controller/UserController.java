package com.store.msm.controller;

import com.store.msm.dto.UserDTO;
import com.store.msm.model.User;
import com.store.msm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody UserDTO dto) {
        try {
            User _user = service.createUser(dto);
            return new ResponseEntity<>("Creado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error:\n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO dto) {
        Optional<User> _user = service.findByUsername(dto.getUsername());
        if (_user.isPresent()) {
            User user = service.createUser(dto);
            return new ResponseEntity<>("Actualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteProduct(@RequestParam(required = true, name = "username") String username) {
        try {
            service.deleteByUsername(username);
            return new ResponseEntity<>("Borrado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error:\n" + e, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
