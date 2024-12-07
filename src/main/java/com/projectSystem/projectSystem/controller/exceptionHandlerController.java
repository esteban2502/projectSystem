package com.projectSystem.projectSystem.controller;

import com.projectSystem.projectSystem.controller.DTO.ErrorDTO;
import com.projectSystem.projectSystem.exception.CanNotCreateException;
import com.projectSystem.projectSystem.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class exceptionHandlerController {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> error(Exception e){
        ErrorDTO error = new ErrorDTO("No se encontro el registro en la base de datos",
                "Informacion sobre el error : "+e,"404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({CanNotCreateException.class})
    public ResponseEntity<?> errorCanNotCreate(Exception e){
        ErrorDTO error = new ErrorDTO("No se pudo crear el registro",
                "Informacion sobre el error :"+e,"400");
        return ResponseEntity.badRequest().body(error);
    }


}
