package com.angular.angular.dto;

import com.angular.angular.entity.Equipo;
import com.angular.angular.entity.Usuario;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data //data permite ecitar escribi los metodos de acceso
public class AsignacionDto {

    private Date fecha_entrega;
    private String sede;
    private boolean teclado;
    private boolean mouse;
    private boolean audifonos;
    private List<Equipo> equipos_id;
    private List<Usuario> usuarios_id;

    public AsignacionDto() {
    }

    public AsignacionDto(Date fecha_entrega, String sede,
                         boolean teclado, boolean mouse, boolean audifonos,
                         List<Equipo> equipos_id, List<Usuario> usuarios_id) {
        this.fecha_entrega = fecha_entrega;
        this.sede = sede;
        this.teclado = teclado;
        this.mouse = mouse;
        this.audifonos = audifonos;
        this.equipos_id = equipos_id;
        this.usuarios_id = usuarios_id;
    }
}
