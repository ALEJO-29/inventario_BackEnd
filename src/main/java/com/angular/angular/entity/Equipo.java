package com.angular.angular.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private int codigo_equipo;
    @Column
    private String disponibilidad;
    @Column
    private int tiket;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String procesador;
    @Column
    private String os;
    @Column
    private String ram;
    @Column
    private String tipo_disco;
    @Column
    private String seriall;
    @Column
    private float precio_compra;
    @Column
    private float precio_actual;
    @Column
    private String numero_factura;
    @Column
    private Date fecha_factura;
    @Column
    private String observaciones;
    @OneToMany(mappedBy = "equipo",cascade = CascadeType.ALL)
    private List<Asignacion> asignacion;

    public Equipo() {
    }

    public Equipo(long id, int codigo_equipo, String disponibilidad, int tiket,
                  String marca, String modelo, String procesador, String os,
                  String ram, String tipo_disco, String seriall, float precio_compra,
                  float precio_actual, String numero_factura, Date fecha_factura,
                  String observaciones, List<Asignacion> asignacion) {
        this.id = id;
        this.codigo_equipo = codigo_equipo;
        this.disponibilidad = disponibilidad;
        this.tiket = tiket;
        this.marca = marca;
        this.modelo = modelo;
        this.procesador = procesador;
        this.os = os;
        this.ram = ram;
        this.tipo_disco = tipo_disco;
        this.seriall = seriall;
        this.precio_compra = precio_compra;
        this.precio_actual = precio_actual;
        this.numero_factura = numero_factura;
        this.fecha_factura = fecha_factura;
        this.observaciones = observaciones;
        this.asignacion = asignacion;
    }
}

