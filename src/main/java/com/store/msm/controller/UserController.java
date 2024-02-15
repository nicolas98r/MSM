package com.store.msm.controller;

import com.store.msm.dto.ResponseDTO;
import com.store.msm.dto.UserDTO;
import com.store.msm.exceptions.ItemExitsException;
import com.store.msm.exceptions.ItemNotFoundException;
import com.store.msm.model.User;
import com.store.msm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final ResponseDTO response = new ResponseDTO();
    @Autowired
    private UserService service;

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserDTO dto) {
        String id = dto.getUsername();
        if (service.findByUsername(id).isPresent()) {
            throw new ItemExitsException(id);
        }
        User user = service.createUser(dto);
        response.setMessage("Creado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO dto) {
        String id = dto.getUsername();
        if (service.findByUsername(id).isPresent()) {
            User user = service.createUser(dto);
            response.setMessage("Actualizado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else throw new ItemNotFoundException(id);
    }

    @DeleteMapping("/")
    public ResponseEntity<ResponseDTO> deleteProduct(@RequestBody UserDTO dto) {
        String id = dto.getUsername();
        if (service.findByUsername(id).isPresent()) {
            service.deleteByUsername(id);
            response.setMessage("Borrado");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else throw new ItemNotFoundException(id);
    }
}
