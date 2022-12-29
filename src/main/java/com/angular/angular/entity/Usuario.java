package com.angular.angular.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int documento;

    @Column
    private String nombre;

    @Column
    private String apellido;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Asignacion> asignacion;

    public Usuario() {
    }

    public Usuario(int id, int documento, String nombre, String apellido, List<Asignacion> asignacion) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignacion = asignacion;
    }
}
