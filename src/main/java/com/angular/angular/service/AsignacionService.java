package com.angular.angular.service;

import com.angular.angular.entity.Asignacion;
import com.angular.angular.entity.Producto;
import com.angular.angular.entity.Usuario;
import com.angular.angular.repository.AsignacionRepository;
import com.angular.angular.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AsignacionService {

    @Autowired
    private AsignacionRepository repository;

    public List<Asignacion> list() {
        return repository.findAll();
    }

    public Optional<Asignacion> getOne(int id) {
        return repository.findById(id);
    }

    public void save(Asignacion asignacion) {
        repository.save(asignacion);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }

}
