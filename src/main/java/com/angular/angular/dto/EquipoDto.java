package com.angular.angular.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class EquipoDto {

    @Setter
    @Getter
    private long id;

    @Setter
    @Getter
    private int codigo_equipo;

    @Setter
    @Getter
    private String disponibilidad;

    @Setter
    @Getter
    private int tiket;

    @Setter
    @Getter
    private String marca;

    @Setter
    @Getter
    private String modelo;

    @Setter
    @Getter
    private String procesador;

    @Setter
    @Getter
    private String os;

    @Setter
    @Getter
    private String ram;

    @Setter
    @Getter
    private String tipo_disco;

    @Setter
    @Getter
    private String seriall;

    @Setter
    @Getter
    private float precio_compra;

    @Setter
    @Getter
    private float precio_actual;

    @Setter
    @Getter
    private String numero_factura;

    @Setter
    @Getter
    private Date fecha_factura;

    @Setter
    @Getter
    private String observaciones;

    public EquipoDto() {
    }

    public EquipoDto(long id, int codigo_equipo, String disponibilidad, int tiket,
                     String marca, String modelo, String procesador, String os,
                     String ram, String tipo_disco, String seriall, float precio_compra,
                     float precio_actual, String numero_factura, Date fecha_factura, String observaciones) {
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
    }
}
