package com.angular.angular.controller;

import com.angular.angular.dto.Mensaje;
import com.angular.angular.dto.UsuarioDto;
import com.angular.angular.entity.Usuario;
import com.angular.angular.repository.UsuarioRepository;
import com.angular.angular.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioCntrolller {

    @Autowired
    private UsuarioService service;
    @Autowired
    private UsuarioRepository repository;


    @GetMapping("/user")
    public List<Usuario> listar() {
        return service.list();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable int id) {
        if (!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe el usuario"), HttpStatus.NOT_FOUND);
        Usuario usuario = service.getOne(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PostMapping("/user")
    public Usuario save(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = service.getOne(id).get();
        usuario.setDocumento(usuarioDto.getDocumento());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        service.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!service.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


}
