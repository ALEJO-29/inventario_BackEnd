package com.angular.angular.service;


import com.angular.angular.entity.Equipo;
import com.angular.angular.entity.Producto;
import com.angular.angular.repository.EquipoRepository;
import com.angular.angular.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipoService {

    @Autowired
    private EquipoRepository repository;

    public List<Equipo> list() {
        return repository.findAll();
    }

    public Optional<Equipo> getOne(long id) {
        return repository.findById(id);
    }

    /*public Optional<Equipo> getByNombre(String marca) {
        return repository.find(marca);
    }*/

    public void save(Equipo equipo) {
        repository.save(equipo);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    /*public boolean existsByNombre(String nombre) {
        return productoRepository.existsByNombre(nombre);
    }*/


}
