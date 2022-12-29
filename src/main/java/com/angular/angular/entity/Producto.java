package com.angular.angular.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Setter
    @Getter
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    @Column
    private String nombre;

    @Setter
    @Getter
    @Column
    private double precio;

    public Producto(String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {
    }
}
