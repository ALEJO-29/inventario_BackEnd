package com.angular.angular.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "asignacion")
@Data
public class Asignacion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date fecha_entrega;
    @Column
    private String sede;
    @Column
    private boolean teclado;
    @Column
    private boolean mouse;
    @Column
    private boolean audifonos;
    @ManyToOne
    @JoinColumn(name = "codigo_equipo", referencedColumnName = "id")
    private Equipo equipo;
    @ManyToOne
    @JoinColumn(name = "nombre", referencedColumnName = "id")
    private Usuario usuario;

    public Asignacion() {
    }

    public Asignacion(int id, Date fecha_entrega, String sede,
                      boolean teclado, boolean mouse, boolean audifonos,
                      Equipo equipo, Usuario usuario) {
        this.id = id;
        this.fecha_entrega = fecha_entrega;
        this.sede = sede;
        this.teclado = teclado;
        this.mouse = mouse;
        this.audifonos = audifonos;
        this.equipo = equipo;
        this.usuario = usuario;
    }
}
