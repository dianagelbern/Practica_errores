package com.manejoerrores.practica.error.excepciones;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message){
        super(message);
    }
}
