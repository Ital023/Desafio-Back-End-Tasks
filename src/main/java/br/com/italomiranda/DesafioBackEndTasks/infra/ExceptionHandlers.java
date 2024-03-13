package br.com.italomiranda.DesafioBackEndTasks.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(){
        return ResponseEntity.badRequest().body("Dado não encontrado");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity threat400(){
        return ResponseEntity.badRequest().body("Falta informações no body");
    }

}
