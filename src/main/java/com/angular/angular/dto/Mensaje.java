package com.angular.angular.dto;

import lombok.Getter;
import lombok.Setter;

public class Mensaje {

    @Setter
    @Getter
    private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
