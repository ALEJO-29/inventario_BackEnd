package com.angular.angular.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class ProductoDto {

    @NotBlank
    @Setter
    @Getter
    private String nombre;
    @Min(0)
    @Setter
    @Getter
    private Double precio;

    public ProductoDto() {
    }

    public ProductoDto(@NotBlank String nombre, @Min(0) Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

}
