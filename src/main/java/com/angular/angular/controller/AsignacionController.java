package com.angular.angular.controller;

import com.angular.angular.dto.AsignacionDto;
import com.angular.angular.dto.Mensaje;
import com.angular.angular.entity.Asignacion;
import com.angular.angular.entity.Equipo;
import com.angular.angular.entity.Usuario;
import com.angular.angular.repository.AsignacionRepository;
import com.angular.angular.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AsignacionController {


    @Autowired
    private AsignacionService service;
    @Autowired
    private AsignacionRepository repository;

    //lista de todas las asignaciones
    @GetMapping("/asignacion")
    public List<Asignacion> listar() {
        return service.list();
    }

    //lista asignacion por id
    @GetMapping("/asignacion/{id}")
    public ResponseEntity<Asignacion> getById(@PathVariable int id) {
        if (!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe dicha asignacion"), HttpStatus.NOT_FOUND);
        Asignacion asignacion = service.getOne(id).get();
        return new ResponseEntity(asignacion, HttpStatus.OK);
    }
    //agregar nuevas asignaciones a la db
    @PostMapping("/asignacion")
    public Asignacion save(@RequestBody Asignacion asignacion) {
        return repository.save(asignacion);
    }

    //actualizar asignaciones
    @PutMapping("/asignacion/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody AsignacionDto asignacionDto) {
        Asignacion asignacion = service.getOne(id).get();
        asignacion.setFecha_entrega(asignacionDto.getFecha_entrega());
        asignacion.setSede(asignacionDto.getSede());
        asignacion.setTeclado(asignacionDto.isTeclado());
        asignacion.setMouse(asignacionDto.isMouse());
        asignacion.setAudifonos(asignacionDto.isAudifonos());
        asignacion.setEquipo((Equipo) asignacionDto.getEquipos_id());;
        asignacion.setUsuario((Usuario) asignacionDto.getUsuarios_id());
        service.save(asignacion);
        return new ResponseEntity(new Mensaje("asignacion actualizado"), HttpStatus.OK);
    }

    //elimina asignaciones
    @DeleteMapping("/asignacion/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("asignacion eliminado"), HttpStatus.OK);
    }

}
