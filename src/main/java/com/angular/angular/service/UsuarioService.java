package com.angular.angular.service;

import com.angular.angular.entity.Producto;
import com.angular.angular.entity.Usuario;
import com.angular.angular.repository.ProductoRepository;
import com.angular.angular.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

        public List<Usuario> list() {
        return repository.findAll();
    }

    public Optional<Usuario> getOne(int id) {
        return repository.findById(id);
    }

    public Optional<Producto> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public void save(Usuario usuario) {
        repository.save(usuario);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }
}
