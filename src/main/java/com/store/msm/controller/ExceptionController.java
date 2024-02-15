package com.store.msm.controller;

import com.store.msm.dto.ResponseDTO;
import com.store.msm.exceptions.ItemExitsException;
import com.store.msm.exceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    private final ResponseDTO response = new ResponseDTO();

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleItemNotFoundException(ItemNotFoundException ex) {
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemExitsException.class)
    public ResponseEntity<ResponseDTO> handleItemNotFoundException(ItemExitsException ex) {
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
