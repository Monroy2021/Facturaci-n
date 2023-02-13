package com.factura_backend.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MensajeExcepcion extends RuntimeException{
    /**
     * Mensaje a devolver
     */
    private String message;

    /**
     * El estado http para lanzar
     */
    private HttpStatus httpStatus;

    public MensajeExcepcion(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
