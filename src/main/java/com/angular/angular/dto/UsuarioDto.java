package com.angular.angular.dto;

import lombok.Data;

@Data
public class UsuarioDto {

    private int documento;

    private String nombre;

    private String apellido;

    public UsuarioDto(int documento, String nombre, String apellido) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public UsuarioDto() {
    }
}
