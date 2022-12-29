package com.angular.angular.controller;

import com.angular.angular.dto.EquipoDto;
import com.angular.angular.dto.Mensaje;
import com.angular.angular.entity.Equipo;
import com.angular.angular.repository.EquipoRepository;
import com.angular.angular.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class EquipoController {

    @Autowired
    private EquipoService service;
    @Autowired
    private EquipoRepository repository;

    @GetMapping("/equipos")
    public List<Equipo> listarEquipo() {
        return service.list();
    }

    @GetMapping("/equipos/{id}")
    public ResponseEntity<Equipo> equiposById(@PathVariable long id) {
        if (!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe tal equipo con dicho id"), HttpStatus.NOT_FOUND);
        Equipo equipo = service.getOne(id).get();
        return new ResponseEntity(equipo, HttpStatus.OK);
    }

    @PostMapping("/equipos")
    public Equipo save(@RequestBody Equipo equipo) {
        return repository.save(equipo);
    }

    @PutMapping("/equipos/{id}")
    public ResponseEntity<?> update(@RequestBody EquipoDto equipoDto, @PathVariable long id) {

        Equipo equipo = service.getOne(id).get();

        equipo.setCodigo_equipo(equipoDto.getCodigo_equipo());
        equipo.setDisponibilidad(equipoDto.getDisponibilidad());
        equipo.setTiket(equipoDto.getTiket());
        equipo.setMarca(equipoDto.getMarca());
        equipo.setProcesador(equipoDto.getProcesador());
        equipo.setOs(equipoDto.getOs());
        equipo.setRam(equipoDto.getRam());
        equipo.setTipo_disco(equipoDto.getTipo_disco());
        equipo.setSeriall(equipoDto.getSeriall());
        equipo.setPrecio_compra(equipoDto.getPrecio_compra());
        equipo.setPrecio_actual(equipoDto.getPrecio_actual());
        equipo.setNumero_factura(equipoDto.getNumero_factura());
        equipo.setFecha_factura(equipoDto.getFecha_factura());
        equipo.setObservaciones(equipoDto.getObservaciones());

        service.save(equipo);
        return new ResponseEntity(new Mensaje("Equipo actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe dicho producto"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
