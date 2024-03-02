package com.store.msm.controller;

import com.store.msm.dto.ResponseDTO;
import com.store.msm.dto.UserDTO;
import com.store.msm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final ResponseDTO response = new ResponseDTO();
    @Autowired
    private UserService service;

    @GetMapping("/{user}")
    public ResponseEntity<UserDTO> getProductById(@PathVariable String user) {
        return new ResponseEntity<>(service.getUserByName(user), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllProducts() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserDTO dto) {
        service.createUser(dto);
        response.setMessage("Creado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO dto) {
        service.createUser(dto);
        response.setMessage("Actualizado");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<ResponseDTO> deleteProduct(@RequestBody UserDTO dto) {
        service.deleteUser(dto);
        response.setMessage("Borrado");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
